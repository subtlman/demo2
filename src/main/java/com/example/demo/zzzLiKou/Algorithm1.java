package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/05/17:25
 * @Description: 二分查找 易
 */
public class Algorithm1 {

    /**
     * 力扣算法题（易）
     *
     * 给定一个 n 个元素有序的（升序）整型数组 nums
     * 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     * 示例一：
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例二：
     * 输入: nums = [-1,0,3,5,9,12], target = 12
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     */

    //不足点
    public int search(int[] nums,int target) {
        // "/"取整 "%"取余
        //获得一组数据的下标为中间的那个值
        int length;
        int lh;
        int j=0;
        int[] nums2 = nums;
        while(1==1){
            //先不用考虑数组长度为奇数或是偶数，功能实现再修改优化
            length= nums2.length;
            lh = length / 2;
            if (length ==1){
                if (nums2[0] ==target){
                    //成功找到值返回下标
                    return j;
                }else{
                    return -1;
                }
            }
            //比较前一半数据，如果值小于比较值 则取后半段数据 否则取数在前半段
            if (nums2[lh-1] <target){
                if (length==2){
                    if (nums2[lh] ==target){
                        //成功找到值返回下标
                        return j+1;
                    }else{
                        return -1;
                    }
                }
                nums2=java.util.Arrays.copyOfRange(nums2,lh,length);
                j=j+lh;
            }else {
                if (length==2){
                    if (nums2[lh-1] ==target){
                        //成功找到值返回下标
                        return j;
                    }else{
                        return -1;
                    }
                }
                nums2=java.util.Arrays.copyOfRange(nums2,0,lh);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 0;
        System.out.println(new Algorithm1().search(nums, target));
        System.out.println(new Algorithm1().search2(nums, target));
    }

    //官方解答
    public int search2(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
