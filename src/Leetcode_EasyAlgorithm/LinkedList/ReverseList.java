package Leetcode_EasyAlgorithm.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/5/13 09:24
 * @Title: 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Description: 方法1：我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
 * 第二个指针 cur 指向 head，然后不断遍历 cur。
 * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
 * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
 * @Analysis: 方法2递归：
 * 不妨假设链表为1，2，3，4，5。按照递归，分别执行了reverseList（1），reverseList（2），
 * reverseList（3），reverseList（4），reverseList（5）
 * 当执行reverseList（5）的时候处罚条件，head.next=null，返回了head就是5。这里面的head其实可以换成temp，保存的是当前节点
 * 之后来到了reverseList(4)，这里面中的p就是reverseList（5）的返回值，就是5这个节点，
 * 接着执行reverseList(4)，当前head是4节点，head.next.next = head;，就是说4.next.next即5.next=head=4，就是说5的下一个节点是4
 * 这样就相当于是逆转了4-5，变成了4-5-4，然后把前面的4-5就是head.next给null，去掉这个顺序，就只剩下5-4了
 * 5->next = 4, 4->next = null。这时候返回了p这个节点，p是5节点，整个新链表是5->4->null，
 * 接下来执行reverseList（3），这里面的p还是5，为什么呢，因为p=reverseList(4)，
 * 而reverseList(4)返回的就是5，这个p就相当于是新链表的头结点
 * reverseList（3）代码解析为4->next = 3,3->next = null，
 * 这个时候p就变成了，5->4->3->null, reverseList(2), reverseList(1)
 * 依次类推，p就是:5->4->3->2->1->null
 * @ThinkingSteps:
 * @TimeConsuming:
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *     val = x;
 *     }
 * }
 */
public class ReverseList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            //在最后一个迭代，比如是1-2-3-4-5的链表，pre到了4，cur到了5，
            // cur还不是null，会做一次反转，从5指向4，然后pre变成5，cur变成null，结束。pre变成首位
            //给和上一句分开看，不是互换两个变量，下面三句合在一起看
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList2(head.next);       //这里面的p是代表新链表的头结点
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
