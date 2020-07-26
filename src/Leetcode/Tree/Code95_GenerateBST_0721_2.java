package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/21 08:31
 * @Title&Description: 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 提示：
 *
 * 0 <= n <= 8
 * @Analysis:
 * 这边输出的是一个TreeNode的List，看题目要求应该是每个元素是一个二叉树的根节点，其中结点的左右子树以及左右子树的左右子树
 * 递归函数输出的应该是一个左右子树关系完善的树的根节点
 *
 * 根据分析，对于每个长度为n的二叉树，都可以以1-n中的每一个为根节点，设根节点为i，i左边的是左子树，i右边的是右子树，
 * 这样可以保证是BST。之后就是递归了。因为每一个根节点的左右子树，都是一个新的BST，都可以选择任意一个结点作为该子树的根，
 * 这样一直到最后。如果只有一个数，那么就是他自己为根，如果根的左边或者右边没有东西了，要置为null。
 * 利用二叉树的递归套路，不同的地方是二叉树的递归套路是使用当前的结点的左右子树来进行递归，
 * 这里面是进行以i为mid的二分算法。其实感觉是差不多的。递归的结果我们首先要确定，得到的是BST的多种排列方式，
 * 里面的元素是一个左右子树关系完善的树的根节点。我们递归得到的是左右子树的排列组合分布，
 * 以递归函数的L和R为范围遍历i为根节点，对左右子树的结果进行排列组合就可以得到我们当前的结果。
 * 比如[2,3]，以2为结点，左子树是null，右子树为3，就一种排列方式。3的左右子树都是null，也即是一种。
 * 以3为根节点，左子树是2，右子树是null，这也是一种组会。
 * 下面是[1,2,3]，以1为根节点，左边是null一种，右边是[2,3]两种，那么就是1*2=2种组合方式；
 * 以2为根节点，左边是1右边是3，一种方式；
 * 以3为根节点，左边是[1,2]两种，右边是null一种，总共2*1=2种
 * 加起来就是2+1+2=5种方式。就可以返回了。
 *
 *
 * 记忆化搜索：因为只要是给定的数目是固定的，二叉树的排列组合也是固定的，所以可以尝试根据结点数量的BST种类设置数组进行保存。
 * 貌似不是很需要的感觉
 * @Summary:
 * @TimeConsuming:
 */
public class Code95_GenerateBST_0721_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 0){
            return new ArrayList<>();
        }
        return process(1, n);
    }

    //递归函数。因为可以根据选取的根节点分出左右的递归函数，所以参数设置L和R
    public List<TreeNode> process(int L, int R){
        List<TreeNode> list = new ArrayList<>();
        //base case。L<R的情况，直接返回null说明越界了
        if (L > R){
            list.add(null);
            return list;
        }
        for (int i=L; i<=R; i++){
            //返回的是左右子树的多种排列可能性。这个List里面是子树的根节点，有多少种排列方式就有多少个元素
            List<TreeNode> leftList = process(L, i-1);
            List<TreeNode> rightList = process(i+1, R);
            //将左右子树的可能性组合起来即可。
            for (TreeNode left : leftList){
                for (TreeNode right : rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        StringBuilder sb = new StringBuilder(2);
        return list;
    }
}
