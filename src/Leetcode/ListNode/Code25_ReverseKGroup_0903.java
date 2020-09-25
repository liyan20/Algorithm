package Leetcode.ListNode;

/**
 * @Author: xianz
 * @Date: 2020/9/3 15:21
 * @Title&Description: 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

public class Code25_ReverseKGroup_0903 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(reverseKGroup(head, 2));
    }

    /**
     * K个一组反转，即每隔k个反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Info info = reverse(head, k);
        if(info.end == null){
            return head;
        }
        ListNode start = info.start;
        ListNode end = info.end;
        ListNode nextStart = info.nextStart;
        dummy.next = start;
        //这下面的判断可以用end也可以用nextStart。
        //下面有一个pre指针指向null还是dummy的问题，如果用nextStart的话，下面如果是dummy，会报环形链表错误。
        //如果这边直接是end的话，下面不管是pre是dummy还是null都没事了
        //我这边使用end。

        //每次反转，将上一次得到的end指针指向新得到的start，是为了将k个一组的链表连起来
        //然后将end指针指向新的end。nextStart指针指向新的返回的nextStart，用于下一次的反转
        while(end != null){
            Info tempInfo = reverse(nextStart, k);
            end.next = tempInfo.start;
            end = tempInfo.end;
            nextStart = tempInfo.nextStart;
        }
        return dummy.next;
    }

    /**
     * 反转从head开始的K个链表
     * @param head
     * @param k
     * @return 返回的Info类，里面是三个属性，这次反转后的K个链表的起点，终点，和没有反转前的下一个结点。
     * 比如1-2-3按照k反转，结果就是返回2作为起点，1作为终点，3作为nextStart。
     */
    public static Info reverse(ListNode head, int k){
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //这边需要注意，假如是1-2，k是2。如果设置成dummy，会在反转后是的1的next是dummy，但是dummy
        //自己的next指针并没有取消掉，所以会报环形链表错误。所以这种必然从head开始反转的时候，pre直接定义成null。
        //如果是从中间开始，可能需要考虑变成dummy
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = head;

        //这边的判断主要是看从head开始的结点是否还有k个，因为按照题意，不足k个的不进行反转
        while(index <= k && temp != null){
            temp = temp.next;
            index++;
        }
        //这边如果小于等于k，说明剩余的结点数量小于k，直接返回就行。
        if(index <= k){
            return new Info(head, null, null);
        }

        //现在说明剩余结点大于等于k个，可以正常进行反转了。
        index = 1;
        while(index <= k){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            index++;
        }
        return new Info(pre, dummy.next, cur);
    }

    /**
     * 里面是三个属性，这次反转后的K个链表的起点，终点，和没有反转前的下一个结点。
     */
    public static class Info{
        public ListNode start;
        public ListNode end;
        public ListNode nextStart;

        public Info(ListNode start, ListNode end, ListNode nextStart){
            this.start = start;
            this.end = end;
            this.nextStart = nextStart;
        }
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
