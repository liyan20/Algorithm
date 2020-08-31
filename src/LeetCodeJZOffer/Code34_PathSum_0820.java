package LeetCodeJZOffer;


/**
 * @Author: xianz
 * @Date: 2020/8/20 08:56
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code34_PathSum_0820 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        System.out.println(pathSum(root, 9));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        process(root, sum, new ArrayList<>(), res);
        return res;
    }

    /**
     *
     * @param root
     * @param rest 还剩下的要遍历的路径和，因为val可能是负数，所以不可以使用res<0来判断
     * @param list
     * @param res
     */
    public static void process(TreeNode root, int rest, List<Integer> list, List<List<Integer>> res){
        //这边直接返回。
        if (root == null){
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);

        //至于为什么要在这边判断是否左右孩子为空，而不是上面判断为空的时候加到res里面
        //是因为写代码时候发现如果是以root是否为空来判断，那么叶子节点有两个孩子都是空的
        //会相加两次，所以有问题的。
        if(rest == root.val && root.left == null && root.right == null){
            res.add(newList);
            return;
        }
        process(root.left, rest - root.val, newList, res);
        process(root.right, rest - root.val, newList, res);
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
