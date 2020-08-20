package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/18 09:08
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code06_ReversePrint_0817 {

    /**
     * 很简单，只需要使用栈就行了
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head != null){
            stack.offerFirst(head);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            arr[i] = stack.pollFirst().val;
            i++;
        }
        return arr;
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
