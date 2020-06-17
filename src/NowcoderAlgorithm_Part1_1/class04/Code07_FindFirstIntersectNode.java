package NowcoderAlgorithm_Part1_1.class04;

/**
 * @Author: xianz
 * @Date: 2020/6/12 08:34
 * @Title&Description: 两个单链表相交的一系列问题
 * 【题目】给定两个可能有环也可能无环的单链表，头节点head1和head2。请实 现一个函数，如果两个链表相交，
 * 请返回相交的 第一个节点。如果不相交，返 回null
 * 【要求】如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)。
 * @Analysis: 首先要判断是不是有环，并且返回环的起点。
 * 1.都没有环的情况：两个相交链表最终一定是Y字型。因为链表只有一个next，相交之后肯定是一起向下的，不会分叉。
 * 如果第二个链表是第一个链表的一部分，那也是Y字型，只不过Y的一边长度位0.
 * 方法1：把链表1放入hashset，之后遍历链表2，第一个存在的就是相交的链表
 * 方法2：遍历两个链表，同时记录结点数量。如果最后一个结点是同一个内存地址，那就是有相交。如果不是，那就不相交。
 * 相交的话这时候让两个链表长度，L1和L2，
 * 假设L1>L2，让L1先走L1-L2那么长，然后一起走。相交的就是需要的。根据计算，L1-(L1-L2) = L2
 * 2.都有环的情况：再分三种情况：
 * 1).两个链表不相交
 * 2).两个链表的入环结点是同一个，即两个链表在环外或者环上相交了。这种情况首先判断两个环起点是不是同一个，是的话就是这种情况
 * 然后把环点当成终点，进行无环链表的相交的情况的判断。形状就是一个Y下面加个环
 * 3).两个链表的入环结点不是同一个。这时候返回的是任意一个入环结点都行。
 * 关于如何判断是情况1还是情况3，因为这两种都是入环结点不是同一个。方法就是链表2不动，对链表1从入环结点开始走
 * 如果一直走回来都没有遇到链表2的入环结点，说明不相交，如果中通遇到了，说明相交。
 * 3.一个有环，一个没环。这种情况不可能发生，不会相交
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_FindFirstIntersectNode {

    public static ListNode getIntersectNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    public static ListNode getLoopNode(ListNode pHead){
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

    //无环单链表的判断
    public static ListNode noLoop(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        int n1 = 0, n2 = 0;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null){
            cur1 = cur1.next;
            n1++;
        }
        while (cur2 != null){
            cur2 = cur2.next;
            n2++;
        }
        if (cur1 != cur2){
            return null;
        }
        //这个判断方式比较好
        cur1 = n1 > n2 ? head1 : head2; //cur1是表示长的那个
        cur2 = cur1 == head1 ? head2 : head1;
        int n = Math.abs(n1 - n2);
        while (n > 0){
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //为了方便，把两个链表的头结点和入环结点都输入方法
    public static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        //这是有环的第二种情况，同一个入环结点
        if (loop1 == loop2){
            int n1 = 0, n2 = 0;
            while (cur1 != loop1){
                cur1 = cur1.next;
                n1++;
            }
            while (cur2 != loop2){
                cur2 = cur2.next;
                n2++;
            }
            //这个判断方式比较好
            cur1 = n1 > n2 ? head1 : head2; //cur1是表示长的那个
            cur2 = cur1 == head1 ? head2 : head1;
            int n = Math.abs(n1 - n2);
            while (n > 0){
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            //入环结点不是同一个
            cur1 = loop1.next;
            //判断是否链表1能转回来
            while (cur1 != loop1){
                //如果中途遇到了链表2
                if (cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }
            //链表1转回自己了
            return null;
        }
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
