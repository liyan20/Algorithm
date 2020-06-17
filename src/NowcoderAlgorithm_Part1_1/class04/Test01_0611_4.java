package NowcoderAlgorithm_Part1_1.class04;

/**
 * @Author: xianz
 * @Date: 2020/6/11 21:26
 * @Title&Description: 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 * @Analysis: 方法就是找到中间的那个，把后面的反转，然后比较。比较完之后再给反转回去
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0611_4 {
    public static void main(String[] args) {

    }

    public boolean chkPalindrome(ListNode A) {
        if (A == null || A.next == null){
            return true;
        }
        ListNode leftEnd = getMidNode(A);  //返回左半部分的终点
        ListNode rightStart = reverse(leftEnd.next);  //这是右半部分的反转后的起点
        ListNode n1 = A;
        ListNode n2 = rightStart;
        //比较两段的val是否相等
        while (n1 != null && n2 != null){
            if (n1.val != n2.val){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //再给反转回来
        leftEnd.next = reverse(rightStart);
        return true;
    }

    public static ListNode getMidNode(ListNode head){
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //这样快指针结束时候，慢指针可以在：4个数在第二个，3个数在第二个这种
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //返回前半部分的最后一个结点，是为了方便后面再给反回来
        return slow;
    }

    public static ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = node;
        ListNode temp;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
