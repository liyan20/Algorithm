package Leetcode_EasyAlgorithm.Trees;

/**
 * @Author: xianz
 * @Date: 2020/5/24 10:46
 * @Title&Description: 二叉搜索树的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 搜索值: 2
 * 你应该返回如下子树:,其实就是返回那个节点
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * @Analysis: 二叉搜索树搜索，根据那个值，如果等于根节点，返回，如果小于根节点，在左子树搜索，否则在右子树搜索
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class SearchInBST {
    public static void main(String[] args) {

    }
    //递归方法
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(val<root.val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
    //迭代的方法，貌似比递归还简单，因为是查找不是遍历
    public TreeNode searchBST2(TreeNode root, int val) {
        TreeNode hot = null;
        while (root!=null && root.val!=val){
            hot = root;
            if(val<root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
