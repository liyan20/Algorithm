package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/22 10:14
 * @Title&Description:
 * 二叉搜索树
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code68_2_LowestCommonAncestorBST_0822 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
