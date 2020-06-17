package Leetcode_EasyAlgorithm.Trees;

/**
 * @Author: xianz
 * @Date: 2020/5/24 10:03
 * @Title&Description: 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @Analysis: 判断二叉搜索树的充要条件是其中序遍历序列是否单调不减
 * 不过这个题目要求是不能相等，那就看是不是单调递增就行了
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Question02_0524_1 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        if(list.size() == 0 || list.size() == 1){
            return true;
        }
        boolean flag = true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void inorderTraversal(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
