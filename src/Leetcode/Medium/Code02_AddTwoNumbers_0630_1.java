package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/29 22:05
 * @Title&Description: 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) +
 *       (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Analysis:
 * 最简单的方法居然不行，会超过long
 * @Summary:
 * @TimeConsuming:
 */
public class Code02_AddTwoNumbers_0630_1 {
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

    //其实看题目给的东西，就是把链表按照顺序相加，如果进位的话就给下面+1就行
    //连Math.pow都不需要，只需要考虑是否进位就行
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        int radix = 0;
        int isCarry = 0;
        while (l1 != null && l2 != null){
            int curNum = l1.val + l2.val + isCarry;
            if (curNum > 9){
                curNode.next = new ListNode(curNum % 10);
                isCarry = 1;
            }else {
                curNode.next = new ListNode(curNum);
                isCarry = 0;
            }
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int curNum = l1.val + isCarry;
            if (curNum > 9){
                curNode.next = new ListNode(curNum % 10);
                isCarry = 1;
            }else {
                curNode.next = new ListNode(curNum);
                isCarry = 0;
            }
            curNode = curNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int curNum = l2.val + isCarry;
            if (curNum > 9){
                curNode.next = new ListNode(curNum % 10);
                isCarry = 1;
            }else {
                curNode.next = new ListNode(curNum);
                isCarry = 0;
            }
            curNode = curNode.next;
            l2 = l2.next;
        }
        if (isCarry == 1){
            curNode.next = new ListNode(1);
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
