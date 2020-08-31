package Leetcode.Tree;

/**
 * @Author: xianz
 * @Date: 2020/8/25 10:32
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
//最大路径和，必须是从上往下的那种
public class Code_maxPath1 {

    public int maxPathSum(TreeNode root) {
        return process(root).allMaxPathSum;
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static class Info {
        public int fromHeadMaxPathSum;// 必须从头节点出发的情况下的最大路径和
        public int allMaxPathSum; // 整棵树的最大路径和

        public Info(int fromHeadMaxPathSum, int allMaxPathSum) {
            this.fromHeadMaxPathSum = fromHeadMaxPathSum;
            this.allMaxPathSum = allMaxPathSum;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        //p1到p3是包含x的三种情况
        int p1 = x.val;  //x自己
        //x决定往左走但是要判断左子树是否为空
        int p2 = x.val + (leftInfo == null ? 0 : leftInfo.fromHeadMaxPathSum);
        //x往右走
        int p3 = x.val + (rightInfo == null ? 0 : rightInfo.fromHeadMaxPathSum);

        //下面是不包含x的情况
        //修正：不包含的其实就是左右子树的最大值了，写在下面了。

        //x要返回的结果
        int fromHeadMaxPathSum = Math.max(Math.max(p1, p2), p3);

        int allMaxPathSum = fromHeadMaxPathSum;
        if (leftInfo != null){
            allMaxPathSum = Math.max(allMaxPathSum, leftInfo.allMaxPathSum);
        }
        if (rightInfo != null){
            allMaxPathSum = Math.max(allMaxPathSum, rightInfo.allMaxPathSum);
        }

        return new Info(fromHeadMaxPathSum, allMaxPathSum);
    }
}
