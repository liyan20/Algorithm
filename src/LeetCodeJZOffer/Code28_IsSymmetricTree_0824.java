package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/24 14:28
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

public class Code28_IsSymmetricTree_0824 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return solution(root.left, root.right);
    }

    /**
     * 递归判断
     * @param left
     * @param right
     * @return
     */
    public static boolean solution(TreeNode left, TreeNode right){
        //如果两个都是null，就是对称
        if(left == null && right == null){
            return true;
        }
        //因为上面判断了不是全都是Null,说明有一个不是空或者都不是空，下面就好写判断代码了
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        //判断左子树的左孩子和右子树的右孩子，以及左子树的右孩子和右子树的左孩子
        return solution(left.left, right.right) && solution(left.right, right.left);
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
