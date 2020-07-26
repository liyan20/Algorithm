package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/26 09:32
 * @Title&Description: 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 提示：
 * 节点总数 <= 10000
 * @Analysis:
 * DFS三种前中后序遍历；BFS层序遍历
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode55_TreeMaxDepth_0726_1 {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //使用二叉树的递归套路。得到我们需要的子树的信息，加上当前结点的信息，得到判断题目要求的结果
    public static int maxDepth1(TreeNode root) {
        return process(root);
    }

    public static int process(TreeNode root){
         if (root == null){
             return 0;
         }
         int leftDepth = process(root.left);
         int rightDepth = process(root.right);
         return Math.max(leftDepth, rightDepth) + 1;
    }

    //使用层序遍历
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size != 0){
                TreeNode cur = queue.pollFirst();
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }


}
