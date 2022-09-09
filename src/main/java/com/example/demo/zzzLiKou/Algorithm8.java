package com.example.demo.zzzLiKou;

import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/08/9:07
 * @Description: 反转字符串
 */
public class Algorithm8 {
    /**
     * 力扣算法题 易
     *
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、
     * 使用 O(1) 的额外空间解决这一问题。
     *
     * 示例一
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * 示例二
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     */

    public void reverseString(char[] s) {

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
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] nums = new char[]{'H','1','2','3','4','5'};
        new Algorithm8().reverseString(nums);
    }


}
