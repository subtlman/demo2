package com.example.demo.zzzLiKou;

import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/06/16:26
 * @Description: 轮转数组
 */
public class Algorithm5 {

    /**
     * 力扣算法题 中等
     *
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * 示例一
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例二
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     */

    //解法一
    //超出时间限制
    public void rotate(int[] nums, int k) {

        if (k==0){
            System.out.println(Arrays.toString(nums));
            return;
        }
        while (k>0){
            //一次转轮
            int j=nums[nums.length-1];
            for (int i = 1; i < nums.length; i++) {
                nums[nums.length-i]=nums[nums.length-1-i];
            }
            nums[0]=j;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int k = 6;
//        new Algorithm5().rotate(nums,k);
        new Algorithm5().rotate2(nums,k);
    }

    //解法二 经历解答错误、执行出错 考虑数组长度小于轮转值
    public void rotate2(int[] nums, int k) {

        if (k==0){
            System.out.println(Arrays.toString(nums));
            return;
        }
        if (k> nums.length){
            final int m = k % nums.length;
            int[] nums2 = Arrays.copyOfRange(nums, nums.length-m, nums.length);
            int[] nums4= Arrays.copyOf(nums2,nums.length);
            int[] nums3 = Arrays.copyOfRange(nums, 0, nums.length-m);
            for (int i = nums2.length,j=0; i < nums4.length; i++,j++) {
                nums4[i]=nums3[j];
            }
            System.arraycopy(nums4, 0, nums, 0, nums4.length);
            System.out.println(Arrays.toString(nums));
            return;
        }
        int[] nums2 = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        int[] nums4= Arrays.copyOf(nums2,nums.length);
        int[] nums3 = Arrays.copyOfRange(nums, 0, nums.length-k);
        for (int i = nums2.length,j=0; i < nums4.length; i++,j++) {
            nums4[i]=nums3[j];
        }
        System.arraycopy(nums4, 0, nums, 0, nums4.length);
        System.out.println(Arrays.toString(nums));
    }

}
