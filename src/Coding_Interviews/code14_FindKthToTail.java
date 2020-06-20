package Coding_Interviews;

import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/20 13:17
 * @Title&Description: 链表中倒数第k个结点
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。这个不是删除
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class code14_FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if (head == null || k <= 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (k != 0){
            fast = fast.next;
            k--;
        }
        //fast是null的时候，意味着k超过了链表的长度，那么就应该直接返回null
        if (fast == null){
            return null;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
