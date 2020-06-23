package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/23 21:33
 * @Title&Description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * @Analysis:
 * 想法是先中序遍历一下，然后找就完事了
 * @Summary:
 * @TimeConsuming:
 */
public class Code230_KthSmallestElementInABst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
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
        return list.get(k - 1);
    }
}

