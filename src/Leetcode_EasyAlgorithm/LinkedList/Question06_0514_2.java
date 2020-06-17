package Leetcode_EasyAlgorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/5/15 14:54
 * @Title&Description: 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * @Analysis: 方法1.把每个链表的结点放入hashmap，如果后面发现用过了这个结点，那就说明有环形的
 * 方法2.设置双指针，快指针一次跑两步，慢指针一次跑一步，如果没有循环，那么快指针会到达末尾，变成null。
 * 如果有循环，在两个指针进入循环圈之后，因为是循环，快的一次跑两步，慢的是一步，快的就比慢的快1，这样至多跑完整个循环的距离，
 * 快的就会追上慢的，这样就说明有循环。需要的时间为 二者距离/速度差，最终结果是 快的==慢的
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question06_0514_2 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head){
        //如果是空链表或者就一个结点，那肯定是不是环形链表
        //其实一个结点的情况在下面已经判断了，不加也可以
        if(head == null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;             //fast需要比slow快，这样在环形链表里面才能根据是否追上slow，
        // 来判断是不是环，要不然下面的相等条件也没法用
        boolean flag = true;
        while (slow != fast){
            //判断到终点的条件是fast为null或者fast.next为null，为啥要加上next呢，是因为fast一次走两步，
            //就是fast.next.next，而要有第二个next必须保证fast.next不为null。
            //所以证明到达了尾结点的标志就是cur为null（直接出去了），或者cur.next==null（最后一个）
            if(fast == null || fast.next == null){
                flag = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return flag;
    }

    public boolean hasCycle2(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode cur = head;
        boolean flag = false;
        while (cur!=null){
            if(map.containsKey(cur)){
                flag = true;
                break;
            }else {
                map.put(cur, 1);
                cur = cur.next;
            }
        }
        return flag;
    }
}
