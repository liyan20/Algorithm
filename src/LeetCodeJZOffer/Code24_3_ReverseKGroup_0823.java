package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/23 10:05
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code24_3_ReverseKGroup_0823 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(reverseKGroup(head, 2));
    }

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
        while(end != null){
            Info tempInfo = reverse(nextStart, k);
            end.next = tempInfo.start;
            end = tempInfo.end;
            nextStart = tempInfo.nextStart;
        }
        return dummy.next;
    }

    public static Info reverse(ListNode head, int k){
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //这边需要注意，加入是1-2，k是2。如果设置成dummy，会在反转后是的1的next是dummy，但是dummy
        //自己的next指针并没有取消掉，所以会报环形链表错误。所以这种必然从head开始反转的时候，pre直接定义成null。
        //如果是从中间开始，可能需要考虑变成dummy
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode temp = head;
        while(index <= k && temp != null){
            temp = temp.next;
            index++;
        }
        if(index <= k){
            return new Info(head, null, null);
        }
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
