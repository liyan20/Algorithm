package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/5 20:53
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code102_LevelOrderTraversal {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                curSize--;
            }
            listAll.add(list);
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




