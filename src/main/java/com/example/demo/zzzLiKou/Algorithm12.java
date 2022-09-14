package com.example.demo.zzzLiKou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/13/9:10
 * @Description: 无重复字符的最长子串
 */
public class Algorithm12 {

    public static void main(String[] args) {

        String s = "wqinntq";
//        System.out.println(new Algorithm12().lengthOfLongestSubstring(s));
        System.out.println(new Algorithm12().lengthOfLongestSubstring2(s));
    }

    /**
     * 力扣算法题 中等
     * <p>
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例一
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例二
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例三
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    //惨败
    public int lengthOfLongestSubstring(String s) {
        final int demo = demo(s);
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String s1 = stringBuilder.toString();
        final int demo1 = demo(s1);
        if (demo > demo1) {
            return demo;
        }
        return demo1;

    }
    public int demo(String s) {
        int len = s.length();
        boolean ch = false;
        if (len == 0) {
            return 0;
        }
        //对于一个字符串而言，无重复字符串的定义和对于子串截取
        //从头依次向着结尾遍历，第一个字符串有无重复情况，接着第二个、第三个、第四个
        //遍历时有多个重复子串，子串又分为同一个子串或者多个不同的子串
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            for (int j = 0; j < chars.length; j++) {
                //对于一个字符串中只有一个字符是重复的情况
                //测试结果出现了abcbb,长度为5
                int i1 = 0;

                if (aChar == chars[j]) {
                    if (j > i) {
                        //如果在两个相同字符中间出现相同的字符
                        final int demo = demo(s.substring(i, j));
                        if (demo !=0){
                            list.add(j - i-demo);
                            break;
                        }
                        list.add(j - i);
                        break;
                    }
                }
                if (list.size() > 0 && j == chars.length - 1) {
                    //如果在结尾的字符串中出现重复的字符再做进一步处理
                    //如果没有重复字符就不用做处理
                    String s1 = s.substring(i);
                    char[] chars1 = s1.toCharArray();
                    for (int l = 0; l < chars1.length; l++) {
                        final char aChar1 = chars1[l];
                        for (int m = 0; m < chars1.length; m++) {
                            if (aChar1 == chars1[m]) {
                                if (m > l) {
                                    ch = true;
                                }
                            }
                        }
                    }
                    if (ch == true) {
                        i1 = demo(s.substring(i, s.length()));
                    }
                    list.add(j + 1 - i - i1);
                    break;
                }
                if (aChar == chars[j]) {
                    if (j > i) {
                        //如果在两个相同字符中间出现相同的字符
                        final int demo = demo(s.substring(i, j));
                        if (demo !=0){
                            list.add(j - i-demo);
                            break;
                        }
                        list.add(j - i);
                        break;
                    }
                }
            }
        }
        int in = 0;
        if (list.size() > 0) {
            in = list.get(0);
            for (Integer integer : list) {
                if (integer > in) {
                    in = integer;
                }
            }
        } else {
            in = len;
        }
        return in;
    }

    //精选优解 暂时没看懂 想睡觉 回头重新阅读理解
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }

}
