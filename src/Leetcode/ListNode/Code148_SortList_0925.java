package Leetcode.ListNode;

import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/9/25 10:04
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code148_SortList_0925 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        printList(sortList(head));
    }

    public static void printList(ListNode head){
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val + "->");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    //选择排序。每次选择最小的那个结点，将其删除并且连接到新的头结点后面就行了
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        ListNode smallPre = dummy;
        ListNode small = head;

        ListNode newDummy = new ListNode(0);
        ListNode curNewDummy = newDummy;

        while(dummy.next != null){
            small = cur;
            smallPre = pre;

            //找到最小的结点。因为其实是和全局的min进行比较，所以是使用cur != null
            while(cur != null){
                if(cur.val < small.val){
                    small = cur;
                    smallPre = pre;
                }
                cur = cur.next;
                pre = pre.next;
            }
            //将cur指向新的循环的结点。如果删除的是head，就指向head的next，如果删除的是中间的，那么就还是head
            cur = dummy.next == small ? dummy.next.next : dummy.next;
            pre = dummy;
            dummy.next = dummy.next == small ? dummy.next.next : dummy.next;

            //下面的删除插入操作要在cur指向的后面，因为插入删除操作会改变结点的指向
            //删除最小结点
            smallPre.next = small.next;
            small.next = null;
            //插入最小结点
            curNewDummy.next = small;
            curNewDummy = curNewDummy.next;
        }
        return newDummy.next;
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
