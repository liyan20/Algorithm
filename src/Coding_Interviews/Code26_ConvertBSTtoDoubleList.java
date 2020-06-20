package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/6/20 09:06
 * @Title&Description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Analysis:
 * 目前的想法是中序遍历，因为二叉搜索树的特点就是中序遍历是有序的，我们进行中序遍历就是按照顺序了
 * @Summary:
 * @TimeConsuming:
 */
public class Code26_ConvertBSTtoDoubleList {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //先写一下中序遍历
    public TreeNode Convert(TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return null;
        }
        TreeNode cur = pRootOfTree;
        TreeNode head = new TreeNode(0);
        head.left = null;
        TreeNode curListNode = head;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }else {
                //在前序遍历的时候，连接left和right
                cur = stack.pollFirst();
                curListNode.right = cur;
                cur.left = curListNode;
                curListNode = curListNode.right;
                cur = cur.right;
            }
        }
        //切断头结点和第一个结点之间的关系，切断第一个结点的left和head的关系
        head.right.left = null;
        return head.right;
    }
}
