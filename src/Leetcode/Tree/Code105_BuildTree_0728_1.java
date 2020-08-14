package Leetcode.Tree;

/**
 * @Author: xianz
 * @Date: 2020/7/28 09:29
 * @Title&Description: 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Analysis:
 * 前序遍历第一个是root，对应到中序遍历找到这个点。
 * 中序遍历root左边的是左子树，右边的是右子树。
 * 前序和中序的左右子树结点数量是一样的。
 * @Summary:
 * @TimeConsuming:
 */
public class Code105_BuildTree_0728_1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1){
            return null;
        }
        return process(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    //根据前序和中序的范围构造当然的根节点，连接到递归的子树上面去
    //因为前序和中序的结点的位置是不一样的，所以用四个参数保存位置。
    public static TreeNode process(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        //如果只有一个结点，那就直接返回root
        if (preLeft == preRight){
            return new TreeNode(preorder[preLeft]);
        }
        //如果越界，越界是因为没有左子树或者右子树的情况，直接返回null
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);  //新建root结点
        //根节点必然是前序遍历的第一个结点。之后在中序遍历里面找到这个点，中序点左边就是左子树，右边是右子树
        //根据中序遍历获得左子树和右子树的size。之后就可以获得前序遍历的左子树和右子树的范围了
        int rootIndex = findInorderIndex(inorder, root);
        int leftSize = rootIndex - inLeft;
        int rightSize = inRight - rootIndex;  //这个好像没有用上
        //下面的递归的范围可以通过画图得到。具体的到时候画个图就行。
        //左子树的前序遍历范围肯定是从当前的下一个开始，到左子树size结束。中序遍历是当前的起点到中序的root前一个
        TreeNode leftSubTree = process(preorder, inorder, preLeft+1, preLeft+leftSize, inLeft, rootIndex-1);
        //右子树也是一样的。前序是从根-左子树-右子树，所以右子树是左子树结束之后一直到当前的终点
        //中序就是从中序的root的下一个开始到当前的终点。
        TreeNode rightSubTree = process(preorder, inorder, preLeft+leftSize+1, preRight, rootIndex+1, inRight);
        //再把这两个子树连起来，返回就可以了
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }

    //找到前序的root对应的中序在哪个地方
    public static int findInorderIndex(int[] inorder, TreeNode node){
        for (int i=0; i<inorder.length; i++){
            if (inorder[i] == node.val){
                return i;
            }
        }
        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
