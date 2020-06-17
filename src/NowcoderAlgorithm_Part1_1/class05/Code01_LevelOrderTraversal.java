package NowcoderAlgorithm_Part1_1.class05;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/4 11:05
 * @Title&Description: 用队列。根节点入队，出队就打印，然后左右分别进去。然后接着下一轮，出队，左右进去。
 * 注意：这个是队列，先进先出和排队一样，根节点的左孩子右孩子是先进去的，所以他们肯定先出来。而左孩子的子树也是
 * 比右孩子的子树先进去的，所以他们肯定是是先出来
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_LevelOrderTraversal {
    public static void main(String[] args) {

    }

    public static List<Node> levelOrderTraversal(Node root){
        List<Node> listAll = new ArrayList<>();
        if (root == null){
            return listAll;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int curSize = 0;
        while (!queue.isEmpty()){
            Node cur = queue.pollFirst();
            listAll.add(cur);
            if (cur.left != null){
                queue.offerLast(cur.left);
            }
            if (cur.right != null){
                queue.offerLast(cur.right);
            }
        }
        return listAll;
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
