package NowcoderAlgorithm_Part1_1.class05;


/**
 * @Author: xianz
 * @Date: 2020/6/6 15:05
 * @Title&Description: 判断是否是二叉搜索树 Binary Search Tree
 * @Analysis: 使用递归思路：
 * 1.判断条件
 * 2.得到所需信息——构建Info类
 * 3.base case; 已知左右子树信息，得到自己结点信息——构建process方法
 * 4.已知自己结点信息，利用条件判断是否符合题意——构建主方法
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_IsBST {
    public static void main(String[] args) {

    }

    //最终的判断上面还是要判断是否为null结点
    public static boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        return process(root).isBST;
    }

    //Info类信息为是否为BST，左边的最大值，右边的最小值
    public static class Info{
        boolean isBST;
        int min;
        int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    //process方法：已知左右子树的Info信息，如何得到自己的信息
    //BST判断条件是左右子树都是BST，并且左边所有值都比自己小，右边所有值都比自己大
    public static Info process(TreeNode x){
        //base case
        if (x == null){
            return null;  //这里面必须要为null，因为下面的判断用到了是否为null
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int min = x.val;
        int max = x.val;
        boolean isBST = false;
        //这里面的操作是更新整个树的最大值和最小值。
        //因为有可能整个树是左子树加上当前结点，那么就是最大值更新，
        // 也可能是右子树加上当前结点，那么就是最大值更新，总之都要更新就完事了
        if (leftInfo != null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        if ((leftInfo == null || (leftInfo != null && leftInfo.isBST && leftInfo.max < x.val))
                &&
                (rightInfo == null || (rightInfo != null && rightInfo.isBST && rightInfo.min > x.val))){
            isBST = true;
        }
        return new Info(isBST, min, max);

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
