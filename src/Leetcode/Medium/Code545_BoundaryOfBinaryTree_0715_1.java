package Leetcode.Medium;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/15 08:30
 * @Title&Description: 545. 二叉树的边界
 * 给定一棵二叉树，以逆时针顺序从根开始返回其边界。边界按顺序包括左边界、叶子结点和右边界而不包括重复的结点。 (结点的值可能重复)
 * 左边界的定义是从根到最左侧结点的路径。右边界的定义是从根到最右侧结点的路径。若根没有左子树或右子树，
 * 则根自身就是左边界或右边界。注意该定义只对输入的二叉树有效，而对子树无效。
 * 最左侧结点的定义是：在左子树存在时总是优先访问，如果不存在左子树则访问右子树。重复以上操作，首先抵达的结点就是最左侧结点。
 * 最右侧结点的定义方式相同，只是将左替换成右。
 * 示例 2
 * 输入:
 *     ____1_____
 *    /          \
 *   2            3
 *  / \          /
 * 4   5        6
 *    / \      / \
 *   7   8    9  10
 * 输出:
 * [1,2,4,7,8,9,10,6,3]
 * 解析:
 * 左边界是结点1,2,4。(根据定义，4是最左侧结点)
 * 叶子结点是结点4,7,8,9,10。
 * 右边界是结点1,3,6,10。(10是最右侧结点)
 * 以逆时针顺序无重复地排列边界，得到答案 [1,2,4,7,8,9,10,6,3]。
 * @Analysis:
 * 杨欢遇到的字节跳动面试题，0714
 * 这题就是找到左边界，叶子节点，右边界。
 * 然后是左边界的定义是从根到最左侧结点的路径，注意是路径，一直找左节点就行，找不到左节点放入右节点，接着找，有点像中序遍历的方法
 * 针对root结点，就如果没有左子树，就没有左节点边界了，左边界就他自己。
 * 然后右节点是一样的。叶子节点应该是会和左节点的最后一个重复的。要注意。叶子节点最后一个也是和右边界最后一个重复。
 * @Summary:
 * @TimeConsuming:
 */
public class Code545_BoundaryOfBinaryTree_0715_1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(boundaryOfBinaryTree(root));
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        findLeftBoundary(root, list);
        findLeafBoundary(root, list);
        findRightBoundary(root, list);
        return list;
    }

    public static void findLeftBoundary(TreeNode root, List<Integer> list){
        if (root.left == null){
            list.add(root.val);
            return;
        }
        //下面的代码把放入list写在左子树前面，保证了每次是先保存结点，然后结点跳到左子树。
        //这样就是最左边的结点也就是第一个叶子节点不会放进去，也就不会重复了。
        while (root.left != null || root.right != null){
            if (root.left != null){
                list.add(root.val);
                root = root.left;
            }else if (root.left == null && root.right != null){
                list.add(root.val);
                root = root.right;
            }
        }
        return;
    }

    public static void findLeafBoundary(TreeNode root, List<Integer> list){
        if (root.left == null && root.right == null){
            return;
        }
        //先序遍历二叉树，是叶子节点就保存。注意入栈是先右后左。
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            if (cur.left == null && cur.right == null){
                list.add(cur.val);
            }
            if (cur.right != null){
                stack.offerFirst(cur.right);
            }
            if (cur.left != null){
                stack.offerFirst(cur.left);
            }
        }
        return;
    }

    public static void findRightBoundary(TreeNode root, List<Integer> res){
        //如果没有右子树，那么右边界就是根节点，已经在左边界出现过，就不需要了
        if (root.right == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        while (root.left != null || root.right != null){
            if (root.right != null){
                list.add(root.val);
                root = root.right;
            }else if (root.right == null && root.left != null){
                list.add(root.val);
                root = root.left;
            }
        }
        list.remove(0);  //去掉第一个根节点的重复情况
        Collections.reverse(list);
        for (int i=0; i<list.size(); i++){
            res.add(list.get(i));
        }
        return;
    }
}
