package NowcoderAlgorithm_Part1_1.class10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/4 10:35
 * @Title&Description: 二叉搜索树BST的一些操作。二叉搜索树的结点的值不相等
 * 查找操作；
 * 插入操作：
 * 现根据查找的操作，找到最后一个不为null的结点，然后根据这个值的大小，插入到左孩子或者右孩子上面。
 *
 * 删除操作：
 * 1.没有左子树也没有右子树：即为叶子节点，那么直接删掉这个结点就行，把其父节点的指针指向null
 * 2.有左子树没有右子树：让左孩子替换自己的位置即可，方法是node的父节点的指针指向node的左孩子
 * 3.没有左子树有右子树：一样的，让node的父节点的指针指向node的右孩子
 * 4.有左子树也有右子树：针对node的右子树，找到右子树最左的那个结点node2，把node2的右树给node2的父节点，
 * 然后把node2单独拿出来，替换掉node的位置即可。
 * 注意：这边需要的应该是对象替换，不能自己新建一个val结点，最好别这样
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class AbstractBinarySearchTree {
    //查找操作。如果node不为null且不等于要查找的值，如果值小于结点值，在左子树找，如果大于，在右子树
    public static Node search(Node root, int val){
        if (root == null){
            return null;
        }
        while (root != null && root.val != val){
            if (val < root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }

    //插入结点，最后返回根节点
    public static Node insert(Node root, int val){
        if (root == null){
            return new Node(val);
        }
        Node node = root;
        Node insertParentNode = root;
        while (node != null){
            insertParentNode = node;
            if (val < node.val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        if (val < insertParentNode.val){
            insertParentNode.left = new Node(val);
        }else {
            insertParentNode.right = new Node(val);
        }
        return root;
    }

    public static Node delete(Node root, int key){
        Node deleteNode = search(root, key);
        if (deleteNode == null){
            return null;
        }
        Node parent = getParentNode(root, deleteNode);
        if (deleteNode.left == null && deleteNode.right == null){
            root = transplant(root, deleteNode, null);
        }else if (deleteNode.left != null && deleteNode.right == null){
            root = transplant(root, deleteNode, deleteNode.left);
        }else if (deleteNode.left == null && deleteNode.right != null){
            root = transplant(root, deleteNode, deleteNode.right);
        }else {
            //这种情况是左右子树都有。我们是选择右子树的最左节点，即为要删除结点的直接后继
            Node successorNode = getMinNode(deleteNode.right);
            //将这个后继的右子树和后继交换，即让后继的父节点连到后继的右子树上面。后继是没有左子树的
            root = transplant(root, successorNode, successorNode.right);
            //目前的后继是单独的结点的，将后继替换要删除的结点。
            root = transplant(root, deleteNode, successorNode);
            successorNode.right = deleteNode.right;
            successorNode.left = deleteNode.left;
        }
        return root;
    }

    //transplant(a, b)，用b去替换a的环境，断连a之后返回新转换的b
    //这个函数主要是修正结点的父节点和当前节点的left或者right关系
    public static Node transplant(Node root, Node nodeToReplace, Node newNode){
        if (root == null || nodeToReplace == null){
            return null;
        }
        Node parent = getParentNode(root, nodeToReplace);
        //父节点是null，说明要替换的root结点
        //仔细想想，这个函数是直接把b结点给替换掉a结点，要求是b的整个子树替换掉整个a的子树
        //要做的就是将a的父节点的孩子由本来的a变成b就行。
        //如果是root结点，假设有一个结点叫god，god.child是root，那么我们要替换掉root，就直接让
        //god.child = b就行，即为root = b;
        if (parent == null){
            root = newNode;
        }else if (nodeToReplace == parent.left){
            parent.left = newNode;
        }else if (nodeToReplace == parent.right){
            parent.right = newNode;
        }
        return root;
    }

    public static Node getMinNode(Node node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    //查找指定结点的父节点
    public static Node getParentNode(Node root, Node node){
        //如果要找的是根节点，父节点就是null
        if (root == null || node == null || node.val == root.val){
            return null;
        }
        Node parent = null;
        //使用二叉树的前序遍历查找父节点
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            Node cur = stack.pollFirst();
            if ((cur.left != null && cur.left == node) || (cur.right != null && cur.right == node)){
                parent = cur;
                break;
            }
            if (node.val < cur.val){
                stack.offerFirst(cur.left);
            }else {
                stack.offerFirst(cur.right);
            }
        }
        return parent;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int value, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
