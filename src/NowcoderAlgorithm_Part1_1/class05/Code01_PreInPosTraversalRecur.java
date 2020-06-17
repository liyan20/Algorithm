package NowcoderAlgorithm_Part1_1.class05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/1 09:37
 * @Title&Description: 二叉树的三种遍历 递归实现
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_PreInPosTraversalRecur {


    public static void preOrderRecur(Node head, List<Integer> list){
        if(head == null){
            return;
        }
        list.add(head.value);     //把当前节点的数值保存起来，也可以直接print
        preOrderRecur(head.left, list);
        preOrderRecur(head.right, list);
    }

    public static void inOrderRecur(Node head, List<Integer> list){
        if(head == null){
            return;
        }
        inOrderRecur(head.left, list);
        list.add(head.value);     //把当前节点的数值保存起来，也可以直接print
        inOrderRecur(head.right, list);
    }

    public static void posOrderRecur(Node head, List<Integer> list){
        if(head == null){
            return;
        }
        posOrderRecur(head.left, list);
        posOrderRecur(head.right, list);
        list.add(head.value);     //把当前节点的数值保存起来，也可以直接print
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int data) {
            this.value = data;
        }
    }
}
