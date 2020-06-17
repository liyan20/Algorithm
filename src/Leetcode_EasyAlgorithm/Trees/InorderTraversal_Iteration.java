package Leetcode_EasyAlgorithm.Trees;
import java.util.*;
/**
 * @Author: xianz
 * @Date: 2020/5/24 07:18
 * @Title&Description: 中序遍历 迭代方法
 * @Analysis: 这个思路和前序遍历的时候是属于同一个左链的思想。但是不同的地方是，前序遍历是先打印自己，
 * 然后转成左结点，同时把右子树入栈。中序遍历是要先打印左结点，然后是根，然后是右结点。
 * 第一个被打印的是左链的末端，然后是末端的根，根也是在左链上面的，然后是右子树。
 *          3
 *        /
 *      20             这里面就是，左链的末端是20，既然是末端，说明他没有左节点了，那只能接着处理他的右结点
 *        \
 *         7
 *  总思想是先把左链所有的都入栈，然后一个个出，打印，出来一个之后接着来处理当前节点的右孩子。这样能够得到
 *  左-根-右，根和左是在一条链上面的，所以先打印左，然后是左的左和右，发现都没有，然后就是接着出栈，就是
 *  之前左节点的根了，这样就能得到打印左-根的情况，然后是根的右，这样就是打印左-根-右了
 * @TimeConsuming:
 */
public class InorderTraversal_Iteration {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //这里面的思想，我觉得是把根节点当成是左节点的逆向左节点，每个栈里面的都是左节点。
        //先打印最后的左节点，然后考虑他的左节点，没有那就是右结点了。
        //右结点也打印完了，这一轮内部循环啥都没干，因为右结点是末端了木有孩子，root是null，
        //然后就是又新的root出栈，这个新的root就是一开始的末端左节点的根了，打印之。
        //所以为什么要把左链给入栈，倒着取出来打印，这样就相当于是打印了左子树然后下一个出来的就是左子树的根，
        // 然后接着打印这个根，再考虑根的右结点就行了。

        //如果是满二叉树那种，到了左链最下面的叶子节点，内部循环结束，root是空了，因为到了叶子节点木有孩子
        // 然后所有的左链都入栈了，之后开始一个个的出栈，然后打印。
        // 然后打印了，之后，转到叶子节点的右孩子，还没有，因为是叶子节点嘛，然后语句搞完了，root还是null
        //接下来就是新的大循环，因为上一波叶子节点的右孩子是null，所以不进行内部循环，直接出栈新的作为root节点，
        //这个出栈的这是就是左链的上一个节点，就是左链最后一个节点的根节点
        while (true){
            while (root!=null){
                stack.offerFirst(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }else {
                root = stack.pollFirst();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
