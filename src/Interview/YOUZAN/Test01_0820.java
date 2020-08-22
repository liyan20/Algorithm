package Interview.YOUZAN;

/**
 * @Author: xianz
 * @Date: 2020/8/20 19:21
 * @Title&Description:
 * 判断回文链表
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0820 {

    /**
     * 方法如下
     * 1.找到链表中间结点
     * 2.反转右半部分的结点，并判断回文
     * 3.把右半部分结点反转回来
     * @param head
     * @return
     */
    public boolean isPalindrome (ListNode head) {
        if(head == null){
            return true;
        }
        ListNode leftEnd = getMidNode(head);
        ListNode rightStart = leftEnd.next;
        ListNode rightReverse = reverse(rightStart);
        ListNode p1 = head;
        ListNode p2 = rightReverse;
        boolean flag = true;
        while (p1 != null && p2 != null){
            if(p1.val != p2.val){
                flag = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //再反转回来
        leftEnd.next = reverse(rightReverse);
        return flag;
    }

    /**
     * 如果链表是奇数，返回前半部分的最后一个位置。
     * 如果链表是偶数，返回最中间的结点位置。
     * @param head
     * @return
     */
    public static ListNode getMidNode(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

}
