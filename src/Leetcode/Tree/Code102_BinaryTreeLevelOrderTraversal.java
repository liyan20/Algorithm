package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/9 18:14
 * @Title&Description: 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listAll = new ArrayList<>();
        if (root == null){
            return listAll;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int curSize = 0;
        while (!queue.isEmpty()){
            curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (curSize > 0){
                TreeNode curNode = queue.pollFirst();
                list.add(curNode.val);
                if (curNode.left != null){
                    queue.offerLast(curNode.left);
                }
                if (curNode.right != null){
                    queue.offerLast(curNode.right);
                }
                curSize--;
            }listAll.add(list);
        }
        return listAll;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
