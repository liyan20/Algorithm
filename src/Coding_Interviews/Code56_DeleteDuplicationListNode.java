package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/11 09:55
 * @Title&Description: 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Analysis: 主要在于重复的结点不保留。
 * 方法1：不考虑空间复杂度的，把val放进hashmap记录个数，然后比对每个结点，对应的个数如果不是1，那就不要
 * 方法2：不使用额外的空间复杂度的方法。遍历链表，遇到第一个重复的时候，while循环到最后一个重复的。
 * 下一个就是不和当前的这个重复的，让新链表的指针指向那个数，接着进行下一轮比较。
 * 如果当前val和下一个val不相同，说明这个当前val是我们需要的东西可以放入新链表种
 * @Summary:
 * @TimeConsuming:
 */
public class Code56_DeleteDuplicationListNode {
    public static void main(String[] args) {
        ListNode phead = new ListNode(2);
        phead.next = new ListNode(4);
        phead.next.next = new ListNode(5);
        phead.next.next.next = new ListNode(5);
//        phead.next.next.next.next = new ListNode(4);
//        phead.next.next.next.next.next = new ListNode(5);
        deleteDuplication(phead);
    }

    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = pHead;
        while (cur != null){
            if (!map.containsKey(cur.val)){
                map.put(cur.val, 1);
            }else {
                map.put(cur.val, map.get(cur.val) + 1);
            }
            cur = cur.next;
        }
        cur = pHead;
        ListNode head = new ListNode(0);
        ListNode cur2 = head;
        while (cur != null){
            if (map.get(cur.val) == 1){
                cur2.next = cur;
                cur2 = cur2.next;
            }else {
                //这个地方是必须要加的，因为如果不加，新的链表的下一个就会延续原链表的那个结点的下一个
                //比如链表是1 2 4 4 5 5，按照循环到了1 2，之后如果不加，循环结束，新链表就会变成1 2 5 5，所以要加。
                cur2.next = null;
            }
            cur = cur.next;
        }
        return head.next;
    }

    public static ListNode deleteDuplication2(ListNode pHead){
        if (pHead == null){
            return null;
        }
        ListNode cur = pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode p = dummy;  //p是新链表的起点
        while (cur != null){
            //这边要把next是否存在放在里面判断
            if (cur.next != null && cur.val == cur.next.val){
                //出现了重复的结点了，开始一直往下找
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }  //跳出循环的时候cur是重复结点的最后一个
                cur = cur.next;  //新结点
                p.next = cur;
            }else { //当前结点和下一个不相同，说明cur是可以连到p上面的结点
                //把p的下一个指向当前的cur，然后p到当前位置
                p.next = cur;
                p = p.next;
//                p = cur;  //也可以把前面两行换成这个，因为cur和cur之间是用next连着的，所以直接p的next关系是借用了cur的
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


