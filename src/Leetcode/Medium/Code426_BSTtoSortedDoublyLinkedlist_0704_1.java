package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/4 09:31
 * @Title&Description: 426. 将二叉搜索树转化为排序的双向链表
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 *
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，
 * 第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
 * 树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code426_BSTtoSortedDoublyLinkedlist_0704_1 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.right = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(treeToDoublyList(root).val);
    }

    //我们就是搞一个中序遍历，在遍历的时候定义生成的链表的指针，连上前后就行
    public static Node treeToDoublyList(Node root){
        if (root == null){
            return null;
        }
        Node cur = root;
        Node head = new Node(0);
        head.left = null;
        head.right = null;
        Node curListNode = head;
        Deque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }else {
                cur = stack.pollFirst();
                curListNode.right = cur;
                cur.left = curListNode;
                curListNode = curListNode.right;
                cur = cur.right;
            }
        }
        //这是个循环链表，和牛客的不一样，一开始没这句老是报空指针错
        head.right.left = curListNode;
        curListNode.right = head.right;
        return head.right;
    }
}
