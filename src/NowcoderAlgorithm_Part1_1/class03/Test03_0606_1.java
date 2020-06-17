package NowcoderAlgorithm_Part1_1.class03;

/**
 * @Author: xianz
 * @Date: 2020/6/6 21:33
 * @Title&Description: 使用插入排序对链表进行排序。
 * Sort a linked list using insertion sort.
 * 示例1
 * 输入
 * {3,2,4}
 * 输出
 * {2,3,4}
 * @Analysis: 插入排序是针对每个i，在0-i-1上面有序，然后来到arr[i]，把这个数插入到前面的数组中。其中，前面数组是排好序的
 * 因为之前插入排序是数组，所以只能一个个比较交换。现在是链表，可以直接插入就完事了.
 * 链表中针对前面的是否是排好序的，可以使用cur.val和cur.next.val进行一下比较
 * @Summary:
 * @TimeConsuming:
 */
public class Test03_0606_1 {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList (ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode index = dummy;
        ListNode node = head;
        while(cur != null && cur.next != null){
            //如果是正确的顺序，遍历继续
            if (cur.val <= cur.next.val){
                cur = cur.next;
            }else {
                //顺序不对了，针对当前的位置不对结点，即cur.next开始往前找合适的位置插入。因为是在else里面，所以前面的是排好序的
                //首先切断当前结点
                node = cur.next;  //记录要移动的结点
                cur.next = node.next;
                //然后开始找前面的位置。数组插入排序是倒着找的，但是链表没法倒着所以只能从头开始
                while (index.next.val <= node.val){
                    index = index.next;
                }
                //找到之后，插入index和index.next之间
                node.next = index.next;
                index.next = node;
                index = dummy;
                //不能进入下一个，首先是之前的下一个是要移动的，给移走了。现在cur.next是之前下一个的下一个
                //所以不是用下面这句
//                cur = cur.next;

            }
        }
        return dummy.next;
    }


    public static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
