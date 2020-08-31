package Leetcode.Search_DynamicPrograming;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/6 09:19
 * @Title&Description: 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * @Analysis: 这个主要是一个满二叉树，就是所有节点都有，但是有可能是null，就很神奇
 * 然后是要统计最大的宽度，宽度定义是左右两个非空节点之间的距离，并且节点之间的null节点也要算
 * 方法：就是记录一下下标就好。结点为i，左孩子为2*i，右孩子结点下标为2*i+1，使用宽度优先遍历
 * @Summary: 新建一个类保存相关信息的方法还是可以的
 * @TimeConsuming:
 */
public class Code662_MaximumWidthOfBinaryTree {

    /**
     * 这个主要是一个满二叉树，就是所有节点都有，但是有可能是null.
     * 然后是要统计最大的宽度，宽度定义是左右两个非空节点之间的距离，并且节点之间的null节点也要算
     * 方法：就是记录一下下标就好。结点为i，左孩子为2*i，右孩子结点下标为2*i+1，使用宽度优先遍历
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<PosTreeNode> queue = new ArrayDeque<>();
        queue.offerLast(new PosTreeNode(root, 1));
        int max = 0; //最大宽度
        int curSize = 0;  //代表当前层的结点个数
        int curMax = 0;  //代表当前层的最大宽度
        //主要思想是在当前层，记录每个结点的下标，然后放入List里面，最后计算最后一个坐标减去第一个坐标+1
        // 就是当前层的包含null结点的宽度
        while (!queue.isEmpty()){
            curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (curSize > 0){
                PosTreeNode curPosTreeNode = queue.pollFirst();
                list.add(curPosTreeNode.pos);
                if (curPosTreeNode.TreeNode.left != null){
                    queue.offerLast(new PosTreeNode(curPosTreeNode.TreeNode.left, 2 * curPosTreeNode.pos));
                }
                if (curPosTreeNode.TreeNode.right != null){
                    queue.offerLast(new PosTreeNode(curPosTreeNode.TreeNode.right, 2 * curPosTreeNode.pos + 1));
                }
                curSize--;
            }
            //这里面考虑到没有结点和只有一个结点的情况。貌似只有一个结点也是可以合并在后面的，这个无所谓了
            curMax = list.size()==0 || list.size()==1 ? list.size() : list.get(list.size()-1) - list.get(0) + 1;
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static class PosTreeNode{
        TreeNode TreeNode;
        int pos;

        public PosTreeNode(TreeNode node, int pos) {
            TreeNode = node;
            this.pos = pos;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}


