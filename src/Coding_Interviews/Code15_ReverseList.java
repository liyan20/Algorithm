package Coding_Interviews;

/**
 * @Author: xianz
 * @Date: 2020/6/10 11:23
 * @Title&Description: 反转链表
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code15_ReverseList {
    public static void main(String[] args) {

    }

    //定义cur和pre结点，将cur.next给pre，然后把这两个后移到下一个结点
    public static ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
