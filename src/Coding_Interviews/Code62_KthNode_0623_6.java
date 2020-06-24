package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/23 22:03
 * @Title&Description: 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code62_KthNode_0623_6 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null){
            return null;
        }
        if (k < 1){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || pRoot != null){
            if (pRoot != null){
                stack.offerFirst(pRoot);
                pRoot = pRoot.left;
            }else {
                pRoot = stack.pollFirst();
                list.add(pRoot);
                pRoot = pRoot.right;
            }
        }
        return k <= list.size() ? list.get(k - 1) : null;
    }

}
