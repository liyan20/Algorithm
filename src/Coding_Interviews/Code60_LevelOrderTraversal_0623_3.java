package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/6/23 17:04
 * @Title&Description: 把二叉树打印成多行
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @Analysis:
 * 就是层序遍历，用队列
 * @Summary:
 * @TimeConsuming:
 */
public class Code60_LevelOrderTraversal_0623_3 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int curSize = queue.size();
            while (curSize != 0){
                TreeNode cur = queue.pollFirst();
                temp.add(cur.val);
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
                curSize--;
            }
            res.add(temp);
        }
        return res;
    }
}
