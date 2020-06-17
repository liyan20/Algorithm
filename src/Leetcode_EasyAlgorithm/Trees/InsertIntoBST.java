package Leetcode_EasyAlgorithm.Trees;

/**
 * @Author: xianz
 * @Date: 2020/5/24 11:23
 * @Title&Description: 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 保证原始二叉搜索树中不存在新值。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class InsertIntoBST {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //基本想法：通过查找找到目标节点的父节点，判断节点左右存在与否，存在的话就不用管了，不存在的话插入
        //这里面要返回这个二叉树，所以就是返回根节点，我们不动root这个参数，
        // 用一个x来执行搜索，这样返回的话直接返回root就行了。这里面其实有问题，我就算是传入root也没事，因为root在
        //下面这个搜索函数里面是参数传递，我主方法的root是没变的，因为主方法里面一直没有对root这个变量做任何操作
        //root始终指向题目的树的根节点。
        //而如果我们把下面搜索的函数给内部代码放到主方法里面就不行了，root的指向会发生变化，会报错的
        TreeNode x = root;
        TreeNode hot = searchBST(x, val);

        //这个判断是如果root是空的,说明这个树是空的，就直接插入就行了
        if(hot==null){
            return new TreeNode(val);
        }
        if((hot.left!=null&&hot.left.val==val) || (hot.right!=null&&hot.right.val==val)){
            return root;
        }
        if(val<hot.val){
            hot.left = new TreeNode(val);
        }else if(val>hot.val){
            hot.right = new TreeNode(val);
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        //这里面的hot指的是查找结束前的最后一个有效节点，就是查找到的节点的父节点，不管是找到了的还是没找到为null的
        TreeNode hot = null;        //为什么要是null而不是一个val为0的节点呢，因为有可能查找出来是空的，比如树是空的情况
        while (root!=null && root.val!=val){
            hot = root;
            if(val<root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return hot;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
