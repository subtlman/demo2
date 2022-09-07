package com.example.demo.zzzLiKou;

import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/06/16:02
 * @Description: 有序数组的平方
 */
public class Algorithm4 {
    /**
     * 力扣算法题 易
     *
     * 给你一个按 非递减顺序 排序的整数数组 nums，
     * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 示例一
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * 示例二
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     */

    //非递减顺序 即是 递增顺序

    //从执行用时、内存消耗、通过测试用例三方面考虑编写代码

    public int[] sortedSquares(int[] nums) {
        int i=0;
        for (int num:nums) {
            nums[i]= num*num;
            i++;
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(new Algorithm4().sortedSquares(nums)));
    }

}
