package com.example.demo.zzzLiKou;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/09/09/10:31
 * @Description: 删除链表的倒数第 N 个结点
 */
public class Algorithm11 {
    /**
     * 力扣算法题 中等
     *
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 示例一
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 示例二
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 示例三
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     */

    //0.1未解答出来  0.2结合精选详解内容提示
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 利用next覆盖前一个结点的思想
         * 借助指针，这里相当于第三方工具一样，第三视角操作链表
         * 你的方法是链表自己跟自己操作，动了全局，而三方工具只会修改该修改的某处
         *
         */
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode head2 = dumpy;//n
        ListNode head3= dumpy;
        while(n>0){
            head2=head2.next;
            n--;
        }
        while(head2.next != null){
            head2=head2.next;
            head3=head3.next;
        }
        head3.next=head3.next.next;
        return dumpy.next;
    }


    public static void main(String[] args) {

    }

    //精选详解
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //定义一个伪节点，用于返回结果
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        //定义一个快指针,指向伪节点，用于遍历链表
        ListNode prev = dumpy;
        //定一个慢指针，
        ListNode tail = dumpy;
        //让快指针先移动 n 步
        while(n >0){
            prev = prev.next;
            n--;
        }
        //只要快指针不指向空，就继续循环
        while(prev.next !=null){
            //让快慢指针同时移动
            tail = tail.next;
            prev = prev.next;
        }
        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        tail.next = tail.next.next;
        //返回为指针指向的头节点
        return dumpy.next;
    }

}
