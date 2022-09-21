package com.example.demo.zzzLiKou;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/20/10:54
 * @Description: 按照频率将数组升序排序  未完成！！ list排序
 */
public class Algorithm17 {

    /**
     * 力扣算法题 易
     * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
     * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     * 请你返回排序后的数组。
     *
     * 示例1
     * 输入：nums = [1,1,2,2,2,3]
     * 输出：[3,1,1,2,2,2]
     * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
     *
     * 示例2
     * 输入：nums = [2,3,1,3,2]
     * 输出：[1,3,3,2,2]
     * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
     *
     * 示例3
     * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
     * 输出：[5,-1,4,4,-6,-6,1,1,1]
     *
     */
    public int[] frequencySort(int[] nums) {

        //根据示例 1、同频率降序排序，不能忽略频率都为1的情况
        //       2、注意正数和负数的情况

        //指针还是循环遍历求取呢

        //循环遍历
        // 1、先算出数组中各元素的频率，
        // 2、然后按照元素频率和数值对数组进行排序即可
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//        for (int value : nums) {
//            map.put(value, 1);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int k=1;
//            final int num = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (j>i){
//                    if (num==nums[j]){
//                        k++;
//                        if (k>map.get(nums[j])){
//                            map.put(nums[i],k);
//                        }
//                    }
//                }
//            }
//        }
//        //完成了第一步，得到了map集合 {1=2, 2=3, 3=1}
//        System.out.println(map);
//        //第二步
//        ArrayList<Object> list = new ArrayList<>();
//        for (int n: map.values()) {
//            //根据values值--频率排序数值
//
//        }
//        return nums;

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            /**
             * 返回指定键映射到的值，如果此映射不包含该键的映射，则返回 defaultValue。
             * 返回num键值对应的value值，没有key值则填充0默认值，有值则在基础上做+1操作-----上步的1操作
             */
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        System.out.println(cnt);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            /**
             * 数组转换成list集合用add
             */
            list.add(num);
        }
        System.out.println(list);
        //可读性[1, 1, 2, 2, 2, 3]-----[3, 1, 1, 2, 2, 2]
        list.sort((a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        System.out.println(list);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a={1,1,2,2,2,3};
        new Algorithm17().frequencySort(a);
    }

    /**
     * ConcurrentHashMap线程安全
     * HashMap线程不安全
     */


}
