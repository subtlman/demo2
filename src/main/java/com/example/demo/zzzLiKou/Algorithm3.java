package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/06/14:51
 * @Description: 搜索插入位置
 */
public class Algorithm3 {

    /**
     * 力扣算法题 易
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 示例一
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *
     * 示例二
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *
     * 示例三
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     */

    //用官方的二分查找做这道算法题 ,超出时间限制
    public int searchInsert(int[] nums, int target) {
        int[] nums2=java.util.Arrays.copyOf(nums,nums.length+1);
        int left = 0, right = nums2.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums2[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid;
            } else {
                left = mid + 1;
                for (int i = nums2.length-1; i > left; i--) {
                    nums2[i] = nums2[i-1];
                }
                nums2[right] = target;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
//        System.out.println(new Algorithm3().searchInsert(nums,target));
        System.out.println(new Algorithm3().searchInsert2(nums,target));
    }

    //如果值存在 则返回该数值的下标 如果不存在则else插入数值 执行速度快
    public int searchInsert2(int[] nums,int target) {
        // "/"取整 "%"取余
        //获得一组数据的下标为中间的那个值
        int length;
        int lh;
        int j=0;
        int[] nums2 = java.util.Arrays.copyOf(nums,nums.length+1);
        while(1==1){
            //先不用考虑数组长度为奇数或是偶数，功能实现再修改优化
            length= nums2.length;
            lh = length / 2;
            if (length ==1){
                return j;
            }
            //比较前一半数据，如果值小于比较值 则取后半段数据 否则取数在前半段
            if (nums2[lh-1] <target){
                if (length==2){
                    return j+1;
                }
                nums2=java.util.Arrays.copyOfRange(nums2,lh,length);
                j=j+lh;
            }else {
                if (length==2){
                    return j;
                }
                nums2=java.util.Arrays.copyOfRange(nums2,0,lh);
            }
        }
    }

}
