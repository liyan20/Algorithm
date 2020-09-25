package NowcoderAlgorithm_Part1_1.class05;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/1 09:48
 * @Title&Description: 二叉树的三种遍历 非递归实现
 * Deque的实现里面，ArrayDeque是数组底层，无法插入null。而LinkedList是可以插入null的
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_PreInPosTraversalUnRecur {
    public static void main(String[] args) {
        Deque<Node> stack = new LinkedList<>();
        System.out.println(stack.pollFirst());
//        stack.take();
//        stack.offerFirst(null);
//        stack.offerFirst(new ListNode(0));
    }
    //前序遍历
    //首先，头结点入栈，之后进行三步：
    //1.弹出栈的一个元素，记为cur，并打印
    //2.将cur的右子树和左子树分别入栈(如果存在的话)。因为栈是后进先出的，所以右子树左子树的顺序入栈，
    // 出来的时候就是左子树右子树的顺序
    //3.如果栈空了，就停止循环
    public static List<Integer> preOrderUnRecur(Node head){
        List<Integer> list = new ArrayList<>();
        if (head == null){
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(head);
        while (!stack.isEmpty()){
            head = stack.pollFirst();  //弹出栈的元素
            //打印当前元素
            list.add(head.value);
            //右子树和左子树不为null的情况下，入栈
            if (head.right != null){
                stack.offerFirst(head.right);
            }
            if (head.left != null){
                stack.offerFirst(head.left);
            }
        }
        return list;
    }

    //后续遍历的很简单，是前序的顺序换一下就行
    //前序遍历入的顺序是弹出中，然后先压入右，再压入左，得到的是中左右的遍历。如果压入的时候先压入右后压入左
    //就可以得到中右左的遍历。如果我们是弹出一个元素就直接打印的话，得到的遍历结果是中右左。
    //如果把这个顺序给收集起来，不打印，最后把这个中右左的顺序逆序着打印，就可以得到左右中的顺序，这就是后序遍历
    //其实先序遍历每次弹出的顺序就是中左右，你看，是先弹出中，然后把右和左放进去，然后下一步弹出左，没有了孩子之后就是弹出右
    //所以我们对上文说的改变了顺序的中右左的弹出给放到栈里面，这样就实现了逆序了，就是左右中，就是后序遍历

    //其实对于前序遍历，我们也可以用一个list把这些节点全部放进去，然后一个个的打印就行，实验证明是可以的
    public static List<Integer> posOrderUnRecur(Node head){
        List<Integer> list = new ArrayList<>();
        if(head == null){
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();  //这个是和前序遍历一样的用来遍历的栈
        Deque<Node> stack2 = new ArrayDeque<>();  //这个是用来保存按照指定顺序遍历的结点的栈，最后用来打印
        stack.offerFirst(head);
        while (!stack.isEmpty()){
            head = stack.pollFirst();
            stack2.offerFirst(head);
            if(head.left != null){
                stack.offerFirst(head.left);
            }
            if(head.right != null){
                stack.offerFirst(head.right);
            }
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pollFirst().value);
        }
        return list;
    }

    //中序遍历
    //中序遍历和前序和后续不太一样，具体方法如下：
    //1.从根节点开始，把所有左链进栈，即对于当前结点，将其左孩子入栈。直到当前结点的左孩子是空了，停止入栈
    //2.弹出结点并打印，对于当前结点，对他的右子树进行同样的操作，即将当前节点换成其右子树，进行操作1。直到栈为空结束

    //那么为什么是这样呢，首先左链是一个个的左孩子，比如是从上到下是d,c,b,a，因为是栈，所以后面这几个结点出栈
    // 的顺序一定是a,b,c,d。
    // 而中序打印的顺序是左中右，所以左链入栈之后弹出第一个就是最左边的结点，然后弹出之后，先不急着弹上一个，而是
    //对这个结点的右子树进行一样的操作，相当于是这样处理：{ a,a的右子树，b，b的右子树，c，c的右子树，d，d的右子树 }
    // [这样对于abcd，每个结点到打印他之前，都是先处理他的左子树然后处理右子树]  比如a，a左节点是空格，处理完了，然后是他自己a，
    //然后是a的右子树。a整个树处理完了，就是b，而b在处理之前，就已经把a的树给处理完了，而a是b的左节点，所以说是在
    //处理b之前已经把b的左子树给处理完了，这就是达到左中的效果，然后处理了b之后就是处理b的右子树。这样就能达到左中右的效果了。

    //一开始的左链入栈是为了找到最左边的那个结点，然后就是最左边那个结点其实是中，他的左孩子是空，返回，打印自己
    // 然后对中的右孩子进行左链处理，就能得到左中右的效果了。你要问如果中的右孩子还有一堆孩子咋办，以小见大，
    //直接按照流程就行了

    //这种处理方法的原理是，每个树都能被拆解成一个个左链来进行。正常的左链，然后对于右子树，可以认为是以右结点为根的一个左链
    public static List<Integer> inOrderUnRecur(Node head){
        List<Integer> list = new ArrayList<>();
        if (head == null){
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();
        //这里面的循环判断多了一个，因为一开始没有把头结点入栈，而是在循环里面放进去的，所以要加个判断
        while (!stack.isEmpty() || head != null){
            //一直入栈左链，直到当前结点的没有左孩子
            if(head != null){
                stack.offerFirst(head);
                head = head.left;
            }else {
                //左孩子是null时候，说明第一步结束，弹出元素，打印，把这个元素的右孩子进行第一步操作。
                //所以这个循环内部是第一步的操作，如果不是空进行第一步，如果是空，
                // 就先出栈打印当前结点，然后就把当前结点指向出栈元素的右孩子
                head = stack.pollFirst();
                list.add(head.value);
                head = head.right;
            }
        }
        return list;
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
