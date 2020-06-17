package Leetcode_EasyAlgorithm.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/5/24 08:40
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class InorderTraversal_Recursion {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return ;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
