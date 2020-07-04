package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/4 11:14
 * @Title&Description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * @Analysis:
 *  * 删除操作：
 *  * 1.没有左子树也没有右子树：即为叶子节点，那么直接删掉这个结点就行，把其父节点的指针指向null
 *  * 2.有左子树没有右子树：让左孩子替换自己的位置即可，方法是node的父节点的指针指向node的左孩子
 *  * 3.没有左子树有右子树：一样的，让node的父节点的指针指向node的右孩子
 *  * 4.有左子树也有右子树：针对node的右子树，找到右子树最左的那个结点node2，把node2的右树给node2的父节点，
 *  * 然后把node2单独拿出来，替换掉node的位置即可。
 * @Summary:
 * @TimeConsuming:
 */
public class Code450_BSTDelete_0704_3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null){
            return null;
        }

    }
}
