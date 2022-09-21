package com.example.demo.zzzLiKou;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/15/9:44
 * @Description: 图像渲染 未完成！！
 */
public class Algorithm14 {

    /**
     * 力扣算法题 易
     *
     * 有一幅以 m x n 的二维整数数组表示的图画 image ，
     * 其中 image[i][j] 表示该图画的像素值大小。
     * 你也被给予三个整数 sr ,  sc 和 newColor 。
     * 你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
     * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的
     * 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上
     * 像素值与初始坐标相同的相连像素点，……，重复该过程。
     * 将所有有记录的像素点的颜色值改为 newColor 。
     * 最后返回 经过上色渲染后的图像 。
     *
     *
     */

    //一遍
    //题目没读懂
    //读官方详解
    //方法一：广度优先搜索
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image ={{1,1,1}, {1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        System.out.println(Arrays.deepToString(new Algorithm14().floodFill(image, sr, sc, color)));
    }

    //方法二：深度优先搜索
    int[] dx2 = {1, 0, 0, -1};
    int[] dy2 = {0, 1, -1, 0};

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor != color) {
            dfs(image, sr, sc, currColor, color);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int currColor, int color) {
        if (image[x][y] == currColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx2[i], my = y + dy2[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currColor, color);
                }
            }
        }
    }



}
