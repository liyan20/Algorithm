package NowcoderAlgorithm_Part1_1.class05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/6/7 10:49
 * @Title&Description: 完全二叉树
 * 判断是不是完全二叉树。完全二叉树就是层序遍历的时候是从左到右一个个的顺序的二叉树
 * @Analysis: 条件：
 * 1.子树不能有右无左
 * 2.如果遇到左右不双全的结点，包括只有左或者都没有，下面的结点必须都是叶子结点
 * @Summary:
 * @TimeConsuming:
 */
public class Code05_IsCBT {
    public static void main(String[] args) {

    }

    public static boolean isCBT(TreeNode root){
        if (root == null){
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        boolean isMeet = false;
        while (!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if ((isMeet && (cur.left != null || cur.right !=null)) ||
                    (cur.left == null && cur.right != null)){
                return false;
            }
            if (cur.left != null){
                queue.offerLast(cur.left);
            }
            if (cur.right != null){
                queue.offerLast(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                isMeet = true;
            }
        }
        return true;
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
