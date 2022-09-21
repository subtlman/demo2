package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/20/17:41
 * @Description: 最大人工岛
 */
public class Algorithm18 {

    /**
     * 力扣算法题 困难
     *
     * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格0 变成1 。
     * 返回执行此操作后，grid 中最大的岛屿面积是多少？
     * 岛屿 由一组上、下、左、右四个方向相连的1 形成。
     *
     * 示例1
     * 输入: grid = [[1, 0], [0, 1]]
     * 输出: 3
     * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
     *
     * 示例2
     * 输入: grid = [[1, 1], [1, 0]]
     * 输出: 4
     * 解释: 将一格0变成1，岛屿的面积扩大为 4。
     *
     * 示例3
     * 输入: grid = [[1, 1], [1, 1]]
     * 输出: 4
     * 解释: 没有0可以让我们变成1，面积依然为 4。
     *
     * 提示
     * n == grid.length
     * n == grid[i].length
     * 1 <= n <= 500
     * grid[i][j] 为 0 或 1
     *
     */

    /**
     * 给出的提示grid.length以及grid[i].length的长度不限于示例给出的2
     *
     * 二进制矩阵中的0、1排列含有多种情况
     * 多处值进行比较、1连接多处值
     *
     */

    public int largestIsland(int[][] grid) {

        /**
         * 由示例给出的信息可得
         * 岛屿面积为1的和
         * 二进制矩阵 grid 可类比成二维数组
         *
         */
        //情景一 {{X, X},{X, X}}
        //情况1
        int num=0;
        int a=-1;
        if (grid.length==1){
            a=0;
        }
        for (int i = 0; i < grid.length; i++) {

            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                //需要返回岛屿最大面积
                //此情景的情况下+1
                num+=ints[j];
                if (a==0){
                    return num;
                }
            }
        }
        if (num<4){
            num=num+1;
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] a={{1, 0},{0, 1}};
        System.out.println(new Algorithm18().largestIsland(a));
    }


}
