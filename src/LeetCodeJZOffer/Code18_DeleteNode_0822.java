package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/22 10:34
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code18_DeleteNode_0822 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                break;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
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
