package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/26 14:56
 * @Title&Description: 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * @Analysis:
 * 原来这题是要求右视图，就是从右往左看的结果，和右边界是不一样的，因为右边界的话比如某一层右边界没了，但是左边还有
 * 就需要接着写左边的。
 * 使用层序遍历就ok
 * @Summary:
 * @TimeConsuming:
 */
public class Code199_TreeRightSideView_0726_2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode cur = queue.pollFirst();
                if (size == 1){
                    res.add(cur.val);
                }
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                size--;  //size还剩1就是这层还有一个的时候，保存就行。
            }
        }
        return res;
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
