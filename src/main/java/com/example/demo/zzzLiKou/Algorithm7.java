package com.example.demo.zzzLiKou;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/07/15:35
 * @Description: 两数之和 II - 输入有序数组
 */
public class Algorithm7 {

    /**
     * 力扣算法习题 中等
     *
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，
     * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
     * 则 1 <= index1 < index2 <= numbers.length 。
     *
     * 以长度为 2 的整数数组 [index1, index2] 的形式
     * 返回这两个整数的下标 index1 和 index2。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * 你所设计的解决方案必须只使用常量级的额外空间。
     *
     * 示例一
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     *
     * 示例二
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
     *
     * 示例三
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     *
     */

    //执行太慢了 尽量避免双重for循环

    /**
     * 精选解题思路
     *
     * 数组中的元素遍历一次，常用于有序数组
     * 如果两个指针指向元素的和 sum == targetsum==target，那么得到要求的结果；
     * 如果 sum > targetsum>target，移动较大的元素，使 sumsum 变小一些；
     * 如果 sum < targetsum<target，移动较小的元素，使 sumsum 变大一些。
     */

    public int[] twoSum(int[] numbers, int target) {

        int a=0;
        int[] numbers2 = new int[2];
        for (int j = 0; j < numbers.length; j++) {
            final int i1 = target - numbers[j];
            for (int i = 1; i < numbers.length; i++) {
                if (i1 == numbers[i]) {
                    numbers2[0] = j + 1;
                    numbers2[1] = i + 1;
                    if (i<numbers.length-1 && numbers[i]==numbers[i+1]){
                        numbers2[1] = i + 2;
                    }
                    a = 1;
                    break;
                }
            }
            if (a==1){
                break;
            }
        }
        return numbers2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,9};
        int k = 12;
        System.out.println(Arrays.toString(new Algorithm7().twoSum(nums,k)));
    }

}
