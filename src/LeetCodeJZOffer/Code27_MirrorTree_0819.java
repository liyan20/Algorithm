package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 16:27
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code27_MirrorTree_0819 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftTree = mirrorTree(root.left);
        TreeNode rightTree = mirrorTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
