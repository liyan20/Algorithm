package Coding_Interviews;

/**
 * @Author: xianz
 * @Date: 2020/6/7 11:33
 * @Title&Description: 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @Analysis: 分析方法：
 * 0.判断条件：判断两个结点是不是镜像结点，这一题比较特殊，需要是判断两个结点，这也比较好写。两个结点需要是
 * 两个结点的val相等；判断o1.left和o2.right是不是对称；判断o1.right和o2.left是不是对称
 * @Summary:
 * @TimeConsuming:
 */
public class Code58_IsSymmetricalTree {
    public static void main(String[] args) {

    }

    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
        return process(pRoot.left, pRoot.right);
    }

    public static boolean process(TreeNode o1, TreeNode o2){
        if (o1 == null && o2 == null){
            return true;
        }
        if ((o1 == null && o2 != null) || (o1 != null && o2 == null)){
            return false;
        }
        return o1.val == o2.val && process(o1.left, o2.right) && process(o1.right, o2.left);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

}
