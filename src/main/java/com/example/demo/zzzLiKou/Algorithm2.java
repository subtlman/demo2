package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/05/17:52
 * @Description: 第一个错误的版本
 */
public class Algorithm2 {

    /**
     * 力扣算法题 易
     * <p>
     * 你是产品经理，目前正在带领一个团队开发新的产品。
     * 不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * <p>
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * <p>
     * 你可以通过调用 bool isBadVersion(version)
     * 接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * <p>
     * 示例一
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * <p>
     * 示例二
     * 输入：n = 1, bad = 1
     * 输出：1
     */

    // 未读懂题意 通过题解知晓
    // 面对数据量大的情况下 防止溢出
    // firstBadVersion 和 isBadVersion
    // 可以通过调用方法isBadVersion(int num)做判断是否为错误版本

    //超出内存限制，执行速度快
    public int firstBadVersion(int n) {

        //获得一组数据的下标为中间的那个值
        int length;
        int lh;
        int[] nums2 = new int[n];
        for (int i = 1; i < n+1; i++) {
            nums2[i-1]=i;
        }
        while (1 == 1) {
            //先不用考虑数组长度为奇数或是偶数，功能实现再修改优化
            length = nums2.length;
            lh = length / 2;
            if(isBadVersion(nums2[0])){
                return nums2[0];
            }
            if (length == 1) {
                return nums2[0];
            }
            //比较前一半数据，如果值小于比较值 则取后半段数据 否则取数在前半段
            if (isBadVersion(nums2[lh])) {
                if (length == 2) {
                    if (isBadVersion(nums2[lh])) {
                        //成功找到值返回下标
                        return nums2[lh];
                    } else {
                        return -1;
                    }
                }
                //本地测试该行在前输出正常结果
                //力扣测试需要交换两个nums值
                //nums2 = copyOf(nums2, lh, length);
                nums2 = java.util.Arrays.copyOfRange(nums2, 0, lh+1);
            } else {
                if (length == 2) {
                    if (isBadVersion(nums2[lh - 1])) {
                        //成功找到值返回下标
                        return nums2[lh];
                    } else {
                        return -1;
                    }
                }
                //nums2 = copyOf(nums2, 0, lh+1);
                nums2 = java.util.Arrays.copyOfRange(nums2, lh, length);
            }
        }

    }
    //对数组进行一定范围的截取，返回新的数组
    public static int[] copyOf(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        int[] copy = new int[newLength];
        for (int i = from ,j=0; i < to; i++,j++) {
            copy[j]=original[i];
        }
        return copy;
    }

    private boolean isBadVersion(int i) {
        if (i>=1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Algorithm2().firstBadVersion(10));
    }

    //官方解答 经过测试执行速度慢
    public int firstBadVersion2(int n) {
        int left = 1, right = n;
        // 循环直至区间左右端点相同
        while (left < right) {
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 答案在区间 [left, mid] 中
                right = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

}
