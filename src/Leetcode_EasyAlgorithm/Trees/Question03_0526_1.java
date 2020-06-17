package Leetcode_EasyAlgorithm.Trees;

/**
 * @Author: xianz
 * @Date: 2020/5/26 21:59
 * @Title&Description: 101.对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question03_0526_1 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right!=null || root.left!=null&&root.right==null){
            return false;
        }
        return root.left.val==root.right.val&&isSymmetric(root.left)&&isSymmetric(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
