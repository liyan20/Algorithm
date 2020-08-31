package Leetcode.Tree;

/**
 * @Author: xianz
 * @Date: 2020/8/25 10:32
 * @Title&Description: 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * * 示例 1:
 * 输入: [1,2,3]
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
//最大路径和，进阶leetcode

public class Code_maxPath3 {

    //定义一个全局变量保存每次的最大值
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }

    public static class Info {
        // 代表必须从头节点出发的情况下的最大路径和
        public int fromHeadMaxPathSum;

        public Info(int fromHeadMaxPathSum) {
            this.fromHeadMaxPathSum = fromHeadMaxPathSum;
        }
    }

    /**
     * 不包含x是一样的，都是取左右子树的最大值即可。
     * 但是包含x不行，左程云的是经过的结点数量，这边是有权重的。
     * 左子树的包含左节点的最大值加上右子树包含右节点的最大值
     * @param x
     * @return
     */
    public Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        //包含x的四种情况。即x的左子树的包含左节点的最大值加上右子树的包含右节点的最大值再加上x的值即可
        //x自己，x加上左子树，x加上右子树，x加上左右子树。都是包含x的
        int p1 = x.val;  //x自己
        //x要加上左子树
        int p2 = x.val + (leftInfo == null ? 0 : leftInfo.fromHeadMaxPathSum);
        //x加上右子树
        int p3 = x.val + (rightInfo == null ? 0 : rightInfo.fromHeadMaxPathSum);

        //包含x要返回的结果。四种情况最大值
        int fromHeadMaxPathSum = Math.max(Math.max(p1, p2), p3);

        //x加上左右子树。这个情况是代表路径是从左边朝上找到x再向右移动到右子树的位置的最大值。
        //因为这个有了重复的移动的问题，所以是不能作为dp传递给上面的fromHeadMaxPathSum的变量的
        //上面的变量是以x为根节点的情况下，向下找的最大值。不能向上的。
        int p4 = x.val + (leftInfo == null ? 0 : leftInfo.fromHeadMaxPathSum) +
                (rightInfo == null ? 0 : rightInfo.fromHeadMaxPathSum);

        max = Math.max(max, Math.max(fromHeadMaxPathSum, p4));
        return new Info(fromHeadMaxPathSum);
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}
