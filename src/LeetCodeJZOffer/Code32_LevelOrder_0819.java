package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 16:46
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code32_LevelOrder_0819 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int size;
        int levelNum = 1;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);
                if(cur.left != null){
                    queue.offerLast(cur.left);
                }
                if(cur.right != null){
                    queue.offerLast(cur.right);
                }
                size--;
            }
            if(levelNum % 2 == 0){
                Collections.reverse(list);
            }
            levelNum++;
            res.add(list);
        }
        return res;
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
