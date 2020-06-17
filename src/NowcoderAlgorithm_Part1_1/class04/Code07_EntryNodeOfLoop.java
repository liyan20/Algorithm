package NowcoderAlgorithm_Part1_1.class04;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/11 14:40
 * @Title&Description: 链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Analysis:
 * 方法1：用hashset。遇到的第一个已经存在的结点就是环的入口
 * 方法2：快慢指针法。
 * 1.fast和slow从头结点出发。fast一次两步，slow一次一步。如果fast==null，说明没环
 * 2.两个相遇后。快指针回到头结点，慢指针停在相遇的地方。
 * 3.两个指针一次一步，再一次相遇就是环的入口
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (pHead != null){
            if (!set.contains(pHead)){
                set.add(pHead);
                pHead = pHead.next;
            }else {
                break;
            }
        }
        return pHead;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if (pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
        //本来fast和slow都是从头结点出发的，但是为了下面的循环比较方便，我们对两个指针进行第一步走。
        //即fast到了第三位，slow到了第二位。这样在一开始上两行加个判断
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow){
            //加这个两个判断的原因是fast一次走两步，要保证next.next不是空指针
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast回到头结点，开始第二次走
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
