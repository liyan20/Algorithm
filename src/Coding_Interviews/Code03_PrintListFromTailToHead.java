package Coding_Interviews;

/**
 * @Author: xianz
 * @Date: 2020/6/11 09:45
 * @Title&Description: 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Analysis: 两个方法：
 * 1.使用ArrayList，放进去再倒序一下
 * 2.使用栈，放进去再拿出来
 * @Summary: 已经全部通过
 * @TimeConsuming:
 */
import java.util.*;
public class Code03_PrintListFromTailToHead {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.offerFirst(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pollFirst().val);
        }
        return list;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
