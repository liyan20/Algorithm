package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/6/30 21:12
 * @Title&Description: 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct ListNode {
 *   int val;
 *   ListNode *left;
 *   ListNode *right;
 *   ListNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @Analysis:
 * 有一个二叉树，保证有两个结点，叶子节点在同一层，把每层从第一个开始，按照顺序连接起来用next指针
 * 我的想法是用层序遍历在每一层，连接一下其next指针
 * @Summary:
 * @TimeConsuming:
 */
public class Code116_PopulatingNextRightPointers_0630_7 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int size = 0;
        Node dummy = new Node(0);
        while (!queue.isEmpty()){
            size = queue.size();
            Node curNext = dummy;
            while (size > 0){
                Node cur = queue.pollFirst();
                curNext.next = cur;
                curNext = curNext.next;
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                size--;
            }
        }
        //因为平白无故的多了一个工具指针，按理说不会有什么影响，但是我还是把他给next置为null，可以直接回收了
        dummy.next = null;
        return root;
    }





    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
