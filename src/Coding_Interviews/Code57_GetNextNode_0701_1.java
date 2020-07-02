package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/1 08:44
 * @Title&Description: 二叉树的下一个结点
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Analysis:
 * 初步想法是进行中序遍历，然后找到那个结点，把下一个给他就行了
 * 这个方法不行，因为可能根本没办法找到。如果next在自己上面
 * @Summary:
 * @TimeConsuming:
 */
public class Code57_GetNextNode_0701_1 {
    //原来这个next指针是node的父节点，草
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(5);
        head.left = new TreeLinkNode(1);
        System.out.println(GetNext(head));
    }

    //是这样的，如果有右孩子，那么就是右孩子的子树的最左边的结点
    //如果没有右孩子，那么1.是父节点的左孩子，就是其父节点就行了；2.是父节点的右孩子，那么需要一层层
    //找父节点，直到当前结点是其父节点的左孩子，返回结点的父节点；3.没有父节点，返回null
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return null;
        }
        //右子树存在的时候，找到右子树的最左结点，返回
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {  //右子树不存在的时候
            //这边必须加上，要不然在pNode.next.left的时候会报空指针错误
            if (pNode.next == null){
                return null;
            }else {
                //是父节点的左节点的时候
                if (pNode == pNode.next.left){
                    return pNode.next;
                }else if (pNode == pNode.next.right){
                    //是父节点的右结点的时候
                    while (pNode.next != null){
                        if (pNode == pNode.next.left){
                            return pNode.next;
                        }
                        pNode = pNode.next;
                    }
                }else {
                    return null;
                }
                return null;
            }
        }
    }
}
