package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/6/6 16:34
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static class Info{
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info process(TreeNode x){
        if (x == null){
            return new Info(true,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        //因为这里面是null的时候返回的不是null，所以就不需要判断了
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced &&
                Math.abs(leftInfo.height-rightInfo.height) <= 1;
        return new Info(isBalanced, height);
    }
}
