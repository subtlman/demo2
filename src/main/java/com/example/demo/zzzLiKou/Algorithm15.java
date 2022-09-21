package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/15/17:21
 * @Description: 合并二叉树 未完成！！
 */
public class Algorithm15 {

    /**
     * 力扣算法题 易
     *
     * 给你两棵二叉树： root1 和 root2 。
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
     * 你需要将这两棵树合并成一棵新二叉树。
     * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
     * 否则，不为 null 的节点将直接作为新二叉树的节点。
     * 返回合并后的二叉树。
     * 注意: 合并过程必须从两个树的根节点开始。
     *
     * 示例一
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     *
     * 示例二
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
     *
     */

    //结果一：超出时间限制
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //找一下规律
        //[3,4,5,5,4,3,7,5,4,3,7,5,4,3,7,5,4,3,7,5,4,3,7]
        //每一行的数量和为 2的行数-1次幂

        //指针
        /**
         * 首先给的二叉树满足结点个数的，不足的尾数会有null值代替x
         * 补充：根据示例，给出的结点个数可能不满足规律，没有空值代替，新的二叉树用到空值代替。
         * 根据上述规律可以判定该二叉树有几层
         * 确定每一层，对该层结点相加作为新的子节点，由上至下重复该过程，
         * 合并成一个新的二叉树
         */

        TreeNode root3 = new TreeNode();//第三方变量值
        root3.left = root1;

        while (root3.left != null){
            root2.val=root3.left.val + root2.val;
            root2.left.val=root3.left.left.val+ root2.left.val;
            root2.right.val=root3.left.right.val+ root2.right.val;
        }
        return root2;

    }


    //官方解答
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1==null || t2==null) {
            return t1==null? t2 : t1;
        }
        return dfs(t1,t2);
    }

    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if(r1==null || r2==null) {
            return r1==null? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }



}
/**
 * Definition for a binary tree node.*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
