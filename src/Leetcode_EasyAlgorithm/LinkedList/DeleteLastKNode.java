package Leetcode_EasyAlgorithm.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/5/12 14:31
 * @Title: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * @Description: 方法：1.先遍历一遍，得到总数，再搞其他的
 * @Analysis: dummy节点的next是head，使用这个可以解决很多种情况 ，比如总共5个，倒数第2，那其实是正数第4个，即正数len-n+1个
 * @ThinkingSteps: 法2：利用两个节点，第一个节点比第二个快n，这样第一个节点到尾节点的时候第二个节点就到了倒数第n个了
 * 经过计算，第一个节点先走n步，然后赋值给node2，两个之间差n，这样Node2就正好是要删除节点的前一个
 * 注意！！！ dummy节点是都需要的，很方便
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
public class DeleteLastKNode {
    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        int num = len-n+1;

        temp = dummy;
        while (num-1>0){          //找到要删除节点的前一个的位置
            temp = temp.next;     //用while也省去了比较for循环中的判断范围是否为0的问题
            num--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = dummy;
        ListNode node2 = dummy;
        while(n>0){
           node1 = node1.next;
           n--;
        }
        while(node1.next!=null){
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
