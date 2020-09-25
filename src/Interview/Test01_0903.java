package Interview;

import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/9/3 09:43
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0903 {

    //判断是否回文
    public static boolean solution(ListNode head){
        if (head == null){
            return false;
        }
        //得到中间结点
        ListNode leftEnd = getMidNode(head);
        ListNode rightStart = reverse(leftEnd.next);
        //遍历两个链表的指针
        ListNode p1 = head;
        ListNode p2 = rightStart;
        while (p1 != null && p2 != null){
            if (p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    //获取中间结点。
    public static ListNode getMidNode(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //反转链表
    public static ListNode reverse(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
}
