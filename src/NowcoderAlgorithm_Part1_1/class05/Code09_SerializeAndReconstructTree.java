package NowcoderAlgorithm_Part1_1.class05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/6/10 08:47
 * @Title&Description: 序列化与反序列化
 * 序列化是根据二叉树的前序遍历，空结点为#，非空的就是里面得val，这每个结点用_分开，得到的一个字符串
 * 反序列化就是根据这个字符串，得到这个二叉树。
 * @Analysis: 序列化的方法就是跟先序遍历一个套路。新建字符串，然后递归的给加上去
 * 反序列化就是为了方便，把字符串里面的数值放到队列里面去，方便递归使用。主方法里面递归得到的结果分别作为左右子树来生成二叉树
 * 其实和左神的二叉树递归套路一样。黑盒得到子树的结果，返回当前结点的什么结果？
 * @Summary:
 * @TimeConsuming:
 */
public class Code09_SerializeAndReconstructTree {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        System.out.println(queue.pollFirst());
    }

    //如果是null的话，用#表示
    public static String serialByPre(Node head){
        if (head == null){
            return "#_";
        }
        //这里面应该是不能用stringbuilder的，因为要新建，可能会有问题
        //其实应该是可以的，sb每次是append上下子树的结果，返回也是一个字符串
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr){
        if (preStr == null){
            return null;
        }
        Deque<String> queue = new ArrayDeque<>();
        String[] strList = preStr.split("_");
        for (int i=0; i<strList.length; i++){
            queue.offerLast(strList[i]);
        }
        return reconPreOrder(queue);
    }

    //用队列的好处是不需要维护一个string数组的到第几个数的index了
    public static Node reconPreOrder(Deque<String> queue){
        if (queue.size() == 0){
            return null;
        }
        String value = queue.pollFirst();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
