package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/7/2 12:47
 * @Title&Description: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code160_IntersectionOfTwoLinkedlists_0702_1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int n1 = 0, n2 = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        //让两个链表走完
        while (cur1.next != null){
            n1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n2++;
            cur2 = cur2.next;
        }
        //因为是以next不为null作为判断条件的，所以最终的要+1
        n1++;
        n2++;
        //如果最后一个不是同一个，那就不相交
        if (cur1 != cur2){
            return null;
        }
        //cur1代表的是长的那个链表
        cur1 = n1 > n2 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        int n = Math.abs(n1 - n2);
        while (n > 0){
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
