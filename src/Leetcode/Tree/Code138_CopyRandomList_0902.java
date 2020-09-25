package Leetcode.Tree;

/**
 * @Author: xianz
 * @Date: 2020/9/2 10:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */


public class Code138_CopyRandomList_0902 {

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(11);
        head.next.next = new ListNode(13);
        copyRandomList(head);
    }

    /**
     * 含有random指针的链表的复制。
     * 主要思想就是在每个链表结点之后新建一个一样val的结点，然后连起来。
     * random指针就通过复制结点的random为前一个原节点的random的next即可。
     *
     * 注意点：node.next.next的地方要注意空指针异常，要判断一下指针是否为空
     * @param head
     * @return
     */
    public static ListNode copyRandomList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            ListNode copyListNode = new ListNode(cur.val);
            cur.next = copyListNode;
            copyListNode.next = next;
            cur = next;
        }
        ListNode newHead = head.next;
        cur = head;
        while(cur != null){
            ListNode copyListNode = cur.next;
            //可能random指针指向的就是null，要判断一下
            copyListNode.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        cur = head;
        ListNode copyListNode = head.next;
        while(cur != null){
            copyListNode = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            //这边遇到copyNode.next.next的时候就要注意一下
            copyListNode.next = copyListNode.next != null ? copyListNode.next.next : null;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
