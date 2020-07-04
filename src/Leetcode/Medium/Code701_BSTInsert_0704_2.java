package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/4 10:59
 * @Title&Description: 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 保证原始二叉搜索树中不存在新值。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * @Analysis:
 * * 插入操作：
 *  * 现根据查找的操作，找到最后一个不为null的结点，然后根据这个值的大小，插入到左孩子或者右孩子上面。
 * @Summary:
 * @TimeConsuming:
 */
public class Code701_BSTInsert_0704_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val){
        //这边需要注意，插入的时候如果根节点是null，返回新的这个结点
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode node = root;
        TreeNode insertParentNode = root;  //这个结点是必须的，因为下面的while循环之后，node结点变成Null了
        while (node != null){
            insertParentNode = node;
            if (val < node.val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        if (val < insertParentNode.val){
            insertParentNode.left = new TreeNode(val);
        }else {
            insertParentNode.right = new TreeNode(val);
        }
        return root;
    }
}
