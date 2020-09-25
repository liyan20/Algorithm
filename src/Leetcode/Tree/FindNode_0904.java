package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/9/4 14:29
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class FindNode_0904 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(20);
        root.left.left.left = new TreeNode(21);
        root.left.left.right = new TreeNode(25);
        System.out.println(binaryTreePaths(root));

    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        process(root, "", 25, list);
        return list;
    }

    /**
     * 查找指定val的结点，保存其路径。
     * @param node
     * @param path
     * @param val
     * @param list
     */
    public static void process(TreeNode node, String path, int val, List<String> list){
        if(node == null){
            return;
        }

        //每次使用新的String保存当前的路径，也可以使用新的list。
        //下面写的这些东西是表明如果path是空的就是说明遇到的是root结点，就不加箭头如果不是就是要加。
        String newPath = path.equals("") ? path + node.val : path + "->" + node.val;
        //如果当前结点是val，说明找到了，保存就行了。
        if(node.val == val){
            list.add(newPath);
            return;
        }
        //如果没找到，左右接着找就行了。
        process(node.left, newPath, val, list);
        process(node.right, newPath, val, list);
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
