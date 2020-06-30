package Leetcode.Medium;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/30 20:49
 * @Title&Description: 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @Analysis:
 * 就是层序遍历，然后从第一行开始，奇数行是从左到右，偶数行从右到左。
 * 我们都是先从左到右，然后reverse一下实现从右到左的效果
 * @Summary:
 * @TimeConsuming:
 */
public class Code103_BinaryTreeZigzagTraversal_0630_5 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int levelNum = 1;
        int size = 0;
        while (!queue.isEmpty()){
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                size--;
            }
            if (levelNum % 2 == 0){
                Collections.reverse(list);
            }
            res.add(list);
            levelNum++;
        }
        return res;
    }

}
