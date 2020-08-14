package Leetcode_EasyAlgorithm.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/5/14 21:51
 * @Title: 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @Description: 想法：查找下一个节点，如果下一个节点的val<=当前的，记录个数。先用ArrayList记录，然后对比即可
 * 时间复杂度应该还好。靠，一开始没考虑负数的情况
 * 优化：
 * 避免使用 O(n) 额外空间的方法就是改变输入。
 * 我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较。
 * 比较完成后我们应该将链表恢复原样。虽然不需要恢复也能通过测试用例，因为使用该函数的人不希望链表结构被更改。
 * 我们可以分为以下几个步骤：
 * 找到前半部分链表的尾节点。
 * 反转后半部分链表。
 * 判断是否为回文。
 * 恢复链表。
 * 返回结果。
 * 执行步骤一，我们可以计算链表节点的数量，然后遍历链表找到前半部分的尾节点。
 * 或者可以使用快慢指针在一次遍历中找到：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。
 * 当快指针移动到链表的末尾时，慢指针到链表的中间。通过慢指针将链表分为两部分。
 * 若链表有奇数个节点，则中间的节点应该看作是前半部分。
 * 步骤二可以使用在反向链表问题中找到解决方法来反转链表的后半部分。
 * 步骤三比较两个部分的值，当后半部分到达末尾则比较完成，可以忽略计数情况中的中间节点。
 * 步骤四与步骤二使用的函数相同，再反转一次恢复链表本身。
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.ArrayList;
import java.util.List;

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
public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head){      //1.找到中间节点2.反转后面的链表3.对比前后的链表4.把链表再给反转回去
        if(head == null){
            return true;
        }
        ListNode endOfFirstHalf = getMiddle(head);
        ListNode startOfSecondHalfReverse = reverse(endOfFirstHalf.next);
        ListNode n1 = head;
        ListNode n2 = startOfSecondHalfReverse;
        boolean flag = true;
        while (n1!=null && n2!=null){           //head一般别动
            if(n1.val!=n2.val){
                flag = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        endOfFirstHalf.next = reverse(startOfSecondHalfReverse);
        return flag;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){          //这个保证比如总共是5个，fast跳了两次到5，slow到3
            fast = fast.next.next;                              //如果是6个，fast到5，slow到3，都能保证slow是在中间
            slow = slow.next;
        }
        return slow;

    }




    public boolean isPalindrome2(ListNode head) {
        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return true;
        }
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if(list.size() == 1){
            return true;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1)) ) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
