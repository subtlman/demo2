package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/13/17:09
 * @Description: 字符串的排列
 */
public class Algorithm13 {

    /**
     * 力扣算法题 中等
     *
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
     * 如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     * 示例一
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     *
     * 示例二
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     *
     */
    public boolean checkInclusion(String s1, String s2) {
        //s1的排列之一，打乱顺序重新排列字符
        //此时的字符串操作方法中的contains不再满足条件
        //解题思路 s2不变 s1变化的字符串
        //考虑s2、s1的组成字符

        /**
         * 由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
         * 根据这一性质，记 s1的长度为 n，我们可以遍历 s2中的每个长度为 n的子串，
         * 判断子串和 s1中每个字符的个数是否相等，若相等则说明该子串是 s1的一个排列。
         * 使用两个数组 cnt1和 cnt2， cnt1统计 s1中各个字符的个数， cnt2统计当前遍历的子串中各个字符的个数。
         * 由于需要遍历的子串长度均为 n，我们可以使用一个固定长度为 n 的滑动窗口来维护 cnt2：滑动窗口每向右滑动一次，
         * 就多统计一次进入窗口的字符，少统计一次离开窗口的字符。然后，判断 cnt1是否与 cnt2相等，
         * 若相等则意味着 s1的排列之一是 s2的子串。
         *
         */
        //a 对应的值是97
        //w 对应的值是119
        //
        final int i = s1.charAt(1) - 'a';
        System.out.println(i);

        return s2.contains(s1);
    }

    public static void main(String[] args) {
        final boolean qwer = new Algorithm13().checkInclusion("qwer","trwre");
    }

}
