package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/6 16:07
 * @Title&Description: 验证平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @Analysis:
 * 条件：左子树平衡，右子树平衡，左右子树高度差不超过1
 * @Summary:
 * @TimeConsuming:
 */
public class Code06_IsBalancedTree {
    public static void main(String[] args) {

    }

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




    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
