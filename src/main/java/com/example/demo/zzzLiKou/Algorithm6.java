package com.example.demo.zzzLiKou;

import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/07/14:55
 * @Description: 移动零
 */
public class Algorithm6 {

    /**
     * 力扣算法题 易
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * 示例一
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 示例二
     * 输入: nums = [0]
     * 输出: [0]
     *
     */

    public void moveZeroes(int[] nums) {
        //对数组进行倒序
        //第一步 [0,1,0,3,12]->[12,3,0,1,0]
        //第二步 [12,3,0,1,0]->[0,3,12,1,0]
        //第三步
        //排除上述解法
        //对数组进行找去零操作
        //接着在原有数组的基础上末尾添加去零的个数0
        int[] nums2 = new int[nums.length];
        for (int i = 0 ,j=0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums2[j]=nums[i];
                j++;
            }
        }
        System.arraycopy(nums2, 0, nums, 0, nums2.length);
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        new Algorithm6().moveZeroes(nums);
    }



}
