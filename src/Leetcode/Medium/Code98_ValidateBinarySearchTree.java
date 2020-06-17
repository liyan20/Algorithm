package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/6 16:05
 * @Title&Description: 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code98_ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    //最终的判断上面还是要判断是否为null结点
    public static boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        return process(root).isBST;
    }

    //Info类信息为是否为BST，左边的最大值，右边的最小值
    public static class Info{
        boolean isBST;
        int min;
        int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    //process方法：已知左右子树的Info信息，如何得到自己的信息
    //BST判断条件是左右子树都是BST，并且左边所有值都比自己小，右边所有值都比自己大
    public static Info process(TreeNode x){
        //base case
        if (x == null){
            return null;  //这里面必须要为null，因为下面的判断用到了是否为null
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int min = x.val;
        int max = x.val;
        boolean isBST = false;
        if (leftInfo != null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        if ((leftInfo == null || (leftInfo != null && leftInfo.isBST && leftInfo.max < x.val))
                &&
                (rightInfo == null || (rightInfo != null && rightInfo.isBST && rightInfo.min > x.val))){
            isBST = true;
        }
        return new Info(isBST, min, max);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
