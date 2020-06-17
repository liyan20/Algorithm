package Leetcode_EasyAlgorithm.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/5/13 11:38
 * @Title: 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *     val = x;
 *     }
 * }
 */
public class Question04_0513_2 {
    public static void main(String[] args) {

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);         //指向链表头结点的结点
        ListNode temp = dummy;                    //temp结点代表当排好序的新链表的当前节点
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;                     //这句的意思是，l1这个变量，现在指向了l1.next这个
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1!=null ? l1 : l2;
        return dummy.next;
    }
}
