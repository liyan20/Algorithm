package Leetcode_EasyAlgorithm.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/5/23 19:16
 * @Title&Description: 树的前序遍历，递归解法
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class PreorderTraversal_Recursion {
    public static void main(String[] args) {

    }
    /*
    递归解法
    既然是遍历二叉树然后保存，对于每个结点的操作就是保存操作，所以要把list当作参数传进来而不是在函数里面自己新建一个
    前序遍历的顺序是：根节点，左子树，右子树
    所以就是先保存根节点，然后递归的针对左结点和右结点调用函数。返回条件是当前节点是空的就返回，空的说明比如到递归左节点的时候
    是空的，返回了然后就是进入递归调用右结点的阶段。递归函数必须要有返沪上一层的条件，返回上一层就是一个return就行了
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //因为leetcode里面的方法类型是list，所以在下面新写了一个函数
        List<Integer> list = new ArrayList<>();
        preTraversal(root, list);
        return list;
    }

    public void preTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
