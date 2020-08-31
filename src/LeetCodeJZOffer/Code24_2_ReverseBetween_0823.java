package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/23 09:04
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code24_2_ReverseBetween_0823 {

    /**
     * 反转从m到n的链表。主要方式还是根据双指针，找到那一段，就反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        //这边可以要也可以不要
        if(m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //这边最需要注意，直接将pre指向dummy，解决了后续的各种空指针问题。
        //因为pre可能是null，而下面有一个pre.next的操作，直接用dummy好一些。
        ListNode pre = dummy;
        ListNode cur = head;
        //定义三个指针。分别保存第一部分的终点，第二部分的终点和第三部分的起点。
        //因为第一部分起点就是head结点，第二部分起点就是最后的pre。第三部分的起点是cur
        ListNode firstEnd;
        ListNode secondEnd;
        ListNode thirdStart;

        //找到反转的起点。使得cur为要反转的那个，pre是反转的前一个
        while(index < m){
            cur = cur.next;
            pre = pre.next;
            index++;
        }
        //记录第一部分的终点和第二部分反转后的终点
        firstEnd = pre;
        secondEnd = cur;
        //开始反转
        while(index <= n){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            index++;
        }
        thirdStart = cur;
        firstEnd.next = pre;
        secondEnd.next = thirdStart;
        return dummy.next;
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
