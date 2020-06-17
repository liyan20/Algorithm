package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/8 11:00
 * @Title&Description: 求一个结点的后继结点（还有前驱结点要自己写一下）
 * 后继结点是指的是中序遍历下，一个结点后面的结点
 * 对于一个结点x，如何得到其后继结点：
 * 1.如果结点x有右子树，那么后继结点在右子树上，因为是中序遍历，左中右，有右子树说明x是在中的位置，那么后继结点一定在右子树上面
 * 而右子树是首先遍历到最左的结点的，所以，x的后继节点在x的右子树的最左结点处
 * 2.如果x没有右子树，说明x是处于左中右的左树的最右的位置，就是左树打印完了的那个位置，下面应该是找中。
 * 方法就是x的父节点开始，往上找，要求父节点不为空，并且当前结点必须是父节点的右孩子。因为是左树的最右的位置嘛。
 * 之后就是当找到了一个结点，是其父节点的左孩子的时候，说明那个父节点就是我们要找的。
 * 因为既然是父节点的左孩子，说明是父节点的左子树，就找到了左中右的那个中了。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code08_SuccessorNode {
    public static void main(String[] args) {

    }

    public static Node successorNode(Node x){
        if (x == null){
            return null;
        }
        if (x.right != null){
            return getMostLeft(x);
        }else {
            Node parent = x.parent;
            //这个判断条件有讲究。如果父节点是null，说明其没有后继。
            //第二个判断条件，父节点的左孩子不是x，取反就是左孩子是x。这个应该是要比判断x == parent.right要准确的
            //即判断了是右孩子，还判断了截止循环时候的是左孩子
            while (parent != null && parent.left != x){
                x = parent;
                parent = x.parent;
            }
            return parent;
        }
    }

    //找到当前结点的树的最左结点
    public static Node getMostLeft(Node x){
        if (x == null){
            return null;
        }
        while (x != null){
            x = x.left;
        }
        return x;
    }




    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
}
