package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/09/9:10
 * @Description: 链表的中间结点
 */
public class Algorithm10 {
    /**
     * 力扣算法题 易
     *
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 示例一
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     *
     * 示例二
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     */

    //提交测试通过 执行用时较优 内存消耗中等
    public ListNode middleNode(ListNode head) {

        int b=1;
        ListNode head2 = head;
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        while (head.next != null) {
            head = head.next;
            b++;
        }

        int c=2;
        while(true){
            head2 = head2.next;
            if(c == b/2+1){
                break;
            }
            c++;
        }
        return head2;
    }

    public static void main(String[] args) {

    }

}
/**
 * Definition for singly-linked list.*/
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

