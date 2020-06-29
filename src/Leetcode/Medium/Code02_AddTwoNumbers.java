package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/29 22:05
 * @Title&Description: 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Analysis:
 * 最简单的方法居然不行，会超过long
 * @Summary:
 * @TimeConsuming:
 */
public class Code02_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] arr1 = {9};
        int[] arr2 = {1,9,9,9,9,9,9,9,9,9};
        ListNode l1 = geneList(arr1);
        ListNode l2 = geneList(arr2);
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }
        long num1 = 0;
        long num2 = 0;
        int i = 0, j = 0;
        while (l1 != null){
            num1 += l1.val * Math.pow(10, i++);
            l1 = l1.next;
        }
        while (l2 != null){
            num2 += l2.val * Math.pow(10, j++);
            l2 = l2.next;
        }
        long num = num1 + num2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        if (num == 0){
            return new ListNode(0);
        }
        while (num > 0){
            cur.next = new ListNode((int)(num % 10));
            num /= 10;
            cur = cur.next;
        }
        return head.next;
    }

    public static ListNode geneList(int[] arr){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i=0; i<arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head.next;
    }

}
