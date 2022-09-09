package com.example.demo.zzzLiKou;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/08/10:33
 * @Description: 反转字符串中的单词 III
 */
public class Algorithm9 {

    /**
     * 力扣算法题 易
     *
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，
     * 同时仍保留空格和单词的初始顺序。
     *
     * 示例一
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * 示例二
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     *
     */

    /**
     * 理解时间复杂度
     * 被用来估算程序的运行时间
     * CPU每个单元的运行消耗时间都是相同的
     * 同一个算法的时间复杂度不是一成不变的，和输入的数据形式依然有关系
     * 选择算法时，面对不同数据量的情况下，不同算法展现出的时间复杂度也不尽相同
     *
     * 理解空间复杂度
     * 对一个算法在运行过程中临时占用存储空间大小的一个量度
     * 相比较而言空间复杂度比之时间复杂度较弱一些
     * 现在的设备存储空间比较大
     * 1GB=1024*1024*1024字节
     * 1GB 大概是10亿字节
     * 1MB 大概是100万字节
     * 1GB=1024MB   1MB=1024KB   1KB=1024字节
     * 也使用大O渐进表示法。
     *
     *
     * 选择算法的原因
     * 面对用程序解决的问题时
     * 1、怎么解出结果 可能消耗大资源或小资源
     * 2、优化过程 以最小的代价换取最大的利益
     * 可供选择的机会有了
     * 时间和空间复杂度对过程做了定性，使得过程有了可比较性
     *
     *
     */

    //执行太慢了，消耗的内存也非常大
    public String reverseWords(String s) {

        String s3 =new String();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            //翻转每个字符串
            String s2 = reverseString(s1[i].toCharArray());
            s3+=s2+" ";
        }
        return s3.trim();
    }

    public String reverseString(char[] s) {

        //头指针和尾指针交换位置
        char a;
        int l = s.length;
        for (int i = 0; i < s.length; i++) {
            if (l-1-i-i>0) { //头指针和尾指针双向移动，减去双倍的i
                a = s[i];
                s[i] = s[l -1- i];
                s[l -1- i] = a;
            }else {
                break;
            }
        }
        String str=new String();
        for (int i = 0; i < s.length; i++) {
            str+=s[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String ss="God Ding";
        System.out.println(new Algorithm9().reverseWords(ss));
    }

    /**
     * java 版的可以通过StringBuilder 的 reverse()方法全反转成字符串，
     * 然后split 空格得到数组， 最后数组倒叙遍历，
     * StringBuilder逐个追加字符串和空格， 最后toString 减掉最后一个空格
     */

}
