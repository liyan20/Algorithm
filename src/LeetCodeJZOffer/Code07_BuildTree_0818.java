package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/18 08:46
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_BuildTree_0818 {

    /**
     * 给定的方法。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    /**
     * 主函数，递归实现二叉树的重建。主要思想是三点：
     * 1.前序遍历的第一个是当前二叉树的root，之后可以在中序中找到对应的位置。
     * 2.中序遍历的root的左边是左子树的数组，右边是右子树的数组
     * 3.前序和中序中，左右子树的数组长度是一样的。前序遍历是root-左-右的顺序，中序遍历是左-root-右的顺序
     * 所以我们是针对每一次递归，找到前序遍历的第一个结点，创建root结点。
     * 之后递归的获取左右子树的结点，递归函数的参数可以根据左右子树的size计算出来
     * 之后将左右子树连到root的left和right指针上面。返回root就行。
     * base case是如果preorder只有一个数，那就是直接返回这个结点就行。如果遍历数组的左位置>右位置，那么返回null
     *
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @param preLeft 前序数组的起点
     * @param preRight 前序数组的终点
     * @param inLeft 中序数组的起点
     * @param inRight 中序数组的终点
     * @return
     */
    public static TreeNode process(int[] preorder, int[] inorder, int preLeft, int preRight,
                                   int inLeft, int inRight){
        if(preLeft == preRight){
            return new TreeNode(preorder[preLeft]);  //只有一个结点，那就是返回自己
        }
        if(preLeft > preRight || inLeft > inRight){  //数组越界，返回null
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);  //新建当前递归的root结点
        int inorderRootIndex = getInorderIndex(inorder, root, inLeft, inRight); //获取root结点在中序数组中的位置
        //计算左右子树的size，来计算下面递归的范围
        int leftSize = inorderRootIndex - inLeft;
        int rightSize = inRight - inorderRootIndex;
        //递归获取左右子树，并连接到root的左右指针上面
        TreeNode leftTree = process(preorder, inorder, preLeft+1, preLeft+leftSize, inLeft, inorderRootIndex-1);
        TreeNode rightTree = process(preorder, inorder, preLeft+leftSize+1, preRight, inorderRootIndex+1, inRight);
        root.left = leftTree;
        root.right = rightTree;
        return root;  //返回根节点即可

    }

    /**
     * 获取root结点在中序数组中的位置
     * @param inorder
     * @param root
     * @param left
     * @param right
     * @return
     */
    public static int getInorderIndex(int[] inorder, TreeNode root, int left, int right){
        for(int i=left; i<=right; i++){
            if(inorder[i] == root.val){
                return i;
            }
        }
        return left;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
