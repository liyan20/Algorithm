package Leetcode_EasyAlgorithm.Trees;

/**
 * @Author: xianz
 * @Date: 2020/6/9 18:34
 * @Title&Description: 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Question05_0609 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null){
            return null;
        }
        return arrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode arrayToBST(int[] nums, int L, int R){
        if (L > R){
            return null;
        }
        int mid = L + ((R - L) >> 1);
        TreeNode head = new TreeNode(nums[mid]);
        head.left = arrayToBST(nums, L, mid - 1);
        head.right = arrayToBST(nums, mid + 1, R);
        return head;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
