package NowcoderAlgorithm_Part1_1.class05;

import java.util.ArrayList;

/**
 * @Author: xianz
 * @Date: 2020/6/18 18:33
 * @Title&Description: 给出一棵二叉树，返回这棵树的中序遍历
 * 例如：
 * 给出的二叉树为{1,#,2,3},
 *    1↵    ↵     2↵    /↵   3↵
 * 返回[1,3,2].
 * 备注：递归的解法太没有新意了，你能用迭代的方法来解这道题吗？
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03_0618_1 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    //非递归的方法。先把所有的左子树搞完，然后是出栈时候打印，之后把右子树放进去。
    public ArrayList<Integer> inorderTraversal (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                //注意，这里面放入的是root而不是root.left，因为根结点还没有放进去
                stack.offerFirst(root);
                root = root.left;
            }else {
                root = stack.pollFirst();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }


}



