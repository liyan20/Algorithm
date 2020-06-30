package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/30 21:02
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code94_BinaryTreeInorderTraversal_0630_6 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        inorderTraversal_Recur(root, list);
        return list;
    }

    public void inorderTraversal_Recur(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        inorderTraversal_Recur(root.left, list);
        list.add(root.val);
        inorderTraversal_Recur(root.right, list);
    }

    public List<Integer> inorderTraversal_UnRecur(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.offerFirst(root);
                root = root.left;
            }else {
                root = stack.pollFirst();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
