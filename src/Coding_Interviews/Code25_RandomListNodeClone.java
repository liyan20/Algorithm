package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/11 11:10
 * @Title&Description: 复杂结点的深度拷贝
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Analysis:
 * 方法1：使用hashmap，key是老结点，value是新结点，弄完之后再连上next和random
 * hashmap的好处是能够找到对应的新老结点
 * 方法2：遍历老结点，把新结点放在老结点的两个结点之间。然后把新老结点一块遍历，把random指针放上去
 * 这样放置新结点的好处是对于每个老结点，可以直接next就找到新结点了，这个可以替换掉hashmap的作用
 * @Summary:
 * @TimeConsuming:
 */
public class Code25_RandomListNodeClone {

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

    public RandomListNode Clone2(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode temp = cur.next;
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }
        cur = pHead;
        while (cur != null){
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        //分开
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur != null){
            RandomListNode next = cur.next.next;
            RandomListNode clone = cur.next;
            cur.next = next;
            clone.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }



    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
