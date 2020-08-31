package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/23 11:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code24_1_ReverseList_0823 {

    /**
     * 这个递归函数的意思是，会发现这个p，就一直没有变过，其实这个p是最后的一个结点，因为最终返回的是
     * 反转后的头节点，所以这个p一直都是一个。
     * 这个递归函数的意思是，假设n(k+1)及其之后的链表都被反转好了
     * 我现在的参数是n(k)的结点，我如何反转n(k)和n(k+1)呢。
     * 那我就把n(k+1)的next指针指向n(k)就行，然后把我自己的n(k)的next指向null
     * 如果不指向null的话，可能会出现环形链表的情况
     *
     * 因为这个递归函数的参数每次都是head.next，所以是一直往后的，我们在返回的过程中反转链表的next关系就行了
     * @param head head是当前的结点，其实相当于迭代过程中的pre指针
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
