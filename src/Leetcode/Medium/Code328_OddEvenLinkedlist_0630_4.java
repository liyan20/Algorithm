package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/30 20:33
 * @Title&Description: 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code328_OddEvenLinkedlist_0630_4 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curOdd = odd;
        ListNode curEven = even;
        int num = 1;
        //根据当前的num，奇数的话连到奇数链表上面，偶数的话连到偶数链表上面
        while (head != null){
            if (num > 2){
                if (num % 2 == 1){
                    curOdd.next = head;
                    curOdd = curOdd.next;
                }else {
                    curEven.next = head;
                    curEven = curEven.next;
                }
            }
            head = head.next;
            num++;
        }
        //这里面有一个问题，比如1-2-3-4-5，取走1-3-5之后，5后面是null，但是偶数链表2-4后面的4还连着5
        //所以要把末尾的next置为null
        curOdd.next = null;
        curEven.next = null;
        curOdd.next = even;
        return odd;
    }
}
