package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/11 19:59
 * @Title&Description: 按之字形顺序打印二叉树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Analysis:
 * 层序遍历而已
 * @Summary:
 * @TimeConsuming:
 */
public class Code59_PrintTreeZhi_0711_1 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(pRoot);
        int size = 0;
        int levelNum = 1;
        while (!queue.isEmpty()){
            size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size != 0){
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);
                size--;
                if (cur.left != null){
                    queue.offerLast(cur.left);
                }
                if (cur.right != null){
                    queue.offerLast(cur.right);
                }
            }
            //偶数行reverse一下
            if (levelNum % 2 != 1){
                Collections.reverse(list);
            }
            res.add(list);
            levelNum++;
        }
        return res;
    }
}
