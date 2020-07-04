package NowcoderAlgorithm_Part1_1.class10;

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
