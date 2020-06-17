package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/6/2 10:39
 * @Title&Description: 226.翻转二叉树
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code226_InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
