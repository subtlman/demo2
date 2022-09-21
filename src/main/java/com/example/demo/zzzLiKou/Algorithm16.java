package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/16/10:11
 * @Description: 填充每个节点的下一个右侧节点指针
 */
public class Algorithm16 {

    /**
     * 力扣算法题 中等
     *
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
     * 二叉树定义如下：
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
     * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有next 指针都被设置为 NULL。
     *
     * 示例一：
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，
     * 以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，
     * 同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     *
     * 示例二
     * 输入：root = []
     * 输出：[]
     *
     */

    public Node connect(Node root) {

        //这道题像是在数组定长时插入#数据

        return null;
    }


}

/*
// Definition for a Node.*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
