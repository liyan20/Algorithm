package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/28 20:18
 * @Title&Description: 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code113_PathSum_0728_2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        process(root, sum, new ArrayList<>(), res);
        return res;
    }

    public static void process(TreeNode root, int rest, List<Integer> path, List<List<Integer>> res){
        if (root == null){
            return;
        }
        //这边是必须要从根节点到叶子节点的。
        if (root.left == null && root.right == null){
            if (rest == root.val){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(root.val);
                res.add(newPath);
            }
            return;
        }
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(root.val);
        process(root.left, rest - root.val, newPath, res);
        process(root.right, rest - root.val, newPath, res);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
