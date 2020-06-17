package Leetcode_EasyAlgorithm.Trees;


import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/5/23 20:55
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class PreorderTraversal_Iteration {
    public static void main(String[] args) {

    }
    //因为是前序遍历，顺序是根-左-右，先打印根，然后是左，所以说左链把根和左都包括了，就直接打印了
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (true){
            //从左节点开始，先找到左链的末尾，中途都打印，因为是根-左-右，同时把右子树入栈
            while (root!=null){
                list.add(root.val);
                stack.offerFirst(root.right);
                root = root.left;
            }
            //关于这个判断为什么在上面
            //因为为空并且退出的情况是最右边的那个结点被访问到了的时候。如果是先出栈后判断的话，
            //出完之后就直接break了，来不及遍历那个结点的。所以这个是放在这边，打印左链，入栈，然后判断栈是否为空。
            //如果是最后一个结点，入栈的是root.left是空的，所以下面stack是空的，可以退出。
            //如果放在后面，还剩一个结点的时候来不及遍历就会退出。

            //我直接加了个else，就好理解多了，如果空了就退出，空了说明栈里面没有右子树了，所有的右子树都出栈了，
            //并且没有新的右子树加进去。如果不是空的，出栈作为根节点
            //至于为什么不把这个放在一开始，因为一开始栈就是空的，先加一波真正的根节点的左链途中的右结点，然后判断
            if(stack.isEmpty()){
                break;
            }else {
                root = stack.pollFirst();
            }
            //左边搞完了，开始遍历右子树，因为是倒着来的，所以需要栈，这里面第一个出来的是左链结尾的第一个右子树
            //之后对于每一个右结点，接着进行找他的左链，如果就一个右结点，那就从栈里面取出来当成根节点，然后打印
            //因为没有右子树，就他自己，所以栈里面放进去的是空的，然后下一次的出栈的root就是上一个存在的右结点
        }
        //总体的想法就是先打印自己，然后是把右结点入栈留着下面倒着用，然后把自己转向左子树。当没有下一个左子树了，
        //结束第一个循环，开始出栈，出栈的是啥呢，出栈的是整个左链上面第一个出现的右子树，然后如法炮制，找到
        //右子树的左链，因为这个右子树可能也是右左右孩子的，就背下来吧
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            root = stack.pollFirst();  //弹出栈的元素
            //打印当前元素
            list.add(root.val);
            //右子树和左子树不为null的情况下，入栈
            if (root.right != null){
                stack.offerFirst(root.right);
            }
            if (root.left != null){
                stack.offerFirst(root.left);
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
