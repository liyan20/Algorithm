package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
//        System.out.println(getParentNode(root, 0).val);
    }

    public static TreeNode search(TreeNode root, int val){
        if (root == null){
            return null;
        }
        while (root != null && root.val != val){
            if (val < root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        TreeNode deleteNode = search(root, key);
        if (deleteNode == null){
            return root;
        }
        TreeNode parent = getParentNode(root, deleteNode);
        if (deleteNode.left == null && deleteNode.right == null){
            root = transplant(root, deleteNode, null);
        }else if (deleteNode.left != null && deleteNode.right == null){
            root = transplant(root, deleteNode, deleteNode.left);
        }else if (deleteNode.left == null && deleteNode.right != null){
            root = transplant(root, deleteNode, deleteNode.right);
        }else {
            //这种情况是左右子树都有。我们是选择右子树的最左节点，即为要删除结点的直接后继
            TreeNode successorNode = getMinNode(deleteNode.right);
            //将这个后继的右子树和后继交换，即让后继的父节点连到后继的右子树上面。后继是没有左子树的
            root = transplant(root, successorNode, successorNode.right);
            //目前的后继是单独的结点的，将后继替换要删除的结点。
            root = transplant(root, deleteNode, successorNode);
            successorNode.right = deleteNode.right;
            successorNode.left = deleteNode.left;
        }
        return root;
    }

    public static TreeNode getMinNode(TreeNode node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    //transplant(a, b)，用b去替换a的环境，断连a之后返回替换后的根节点
    //这个函数主要是修正结点的父节点和当前节点的left或者right关系
    public static TreeNode transplant(TreeNode root, TreeNode nodeToReplace, TreeNode newNode){
        if (root == null){
            return null;
        }
        //因为这边的root = newNode是赋值运算，没有改变root传进来时候指向的那个对象，所以要想得到改变后的root的值，
        //必须返回root变量才行
        TreeNode parent = getParentNode(root, nodeToReplace);
        //如果要替换的是root结点，就直接把root的左右给newNode
        //父节点是null，说明要替换的root结点
        //仔细想想，这个函数是直接把b结点给替换掉a结点，要求是b的整个子树替换掉整个a的子树
        //要做的就是将a的父节点的孩子由本来的a变成b就行。
        //如果是root结点，假设有一个结点叫god，god.child是root，那么我们要替换掉root，就直接让
        //god.child = b就行，即为根节点root = b;
        if (parent == null){
            root = newNode;
        }else if (nodeToReplace == parent.left){
            parent.left = newNode;
        }else if (nodeToReplace == parent.right){
            parent.right = newNode;
        }
        return root;
    }

    public static TreeNode getParentNode(TreeNode root, TreeNode node){
        //如果要找的是根节点，父节点就是null
        if (root == null || node == null || node.val == root.val){
            return null;
        }
        TreeNode parent = null;
        //使用二叉树的前序遍历查找父节点
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            if ((cur.left != null && cur.left == node) || (cur.right != null && cur.right == node)){
                parent = cur;
                break;
            }
            if (node.val < cur.val){
                stack.offerFirst(cur.left);
            }else {
                stack.offerFirst(cur.right);
            }
        }
        return parent;
    }
}
