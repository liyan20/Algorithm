package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/22 09:53
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */


public class Code68_1_LowestCommonAncestor_0822 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).ansNode;
    }

    /**
     * 以x为根节点的子树，返回发现最近公共祖先的情况的信息Info
     *
     * 几种情况。1.首先是存在p,q结点的情况。
     * 1.1分别在左子树和右子树或者在右子树或者左子树，那么x就是ansNode
     * 1.2 & 1.3都在左子树或者右子树，这时候左子树或者右子树的Info的ansNode不为空，
     * 那么本次递归的ansNode就是左子树或者右子树的ansNode，因为是要求最近的
     * 2 & 3.不存在p或者不存在q或者都不存在的情况。但是要考虑x本身是不是p或者q的情况
     * @param x
     * @param p
     * @param q
     * @return
     */
    public static Info process(TreeNode x, TreeNode p, TreeNode q){
        if(x == null){
            return new Info(null, false, false);
        }
        Info leftInfo = process(x.left, p, q);
        Info rightInfo = process(x.right, p, q);

        //存在的三种情况写完了
        if((leftInfo.findO1 && rightInfo.findO2) || (leftInfo.findO2 && rightInfo.findO1)){
            return new Info(x, true, true);
        }
        if(leftInfo.ansNode != null){
            return new Info(leftInfo.ansNode, true, true);
        }
        if(rightInfo.ansNode != null){
            return new Info(rightInfo.ansNode, true, true);
        }

        //这是只发现一个结点或者都不存在的情况。但是本身x是不是p或者q需要考虑
        boolean findO1 = x == p;
        boolean findO2 = x == q;
        //判断是否x是q的情况
        if(leftInfo.findO1 || rightInfo.findO1){
            if(findO2){
                return new Info(x, true, true);
            }else{
                return new Info(null, true, false);
            }
        }
        //判断是否x是p的情况
        if(leftInfo.findO2 || rightInfo.findO2){
            if(findO1){
                return new Info(x, true, true);
            }else{
                return new Info(null, false, true);
            }
        }
        //最后到这边的就是左右子树都不存在p和q的情况了，那么只剩下x自己是不是p或者q的判断，并且绝对不可能有公共祖先
        return new Info(null, findO1, findO2);

    }

    public static class Info{
        TreeNode ansNode;
        boolean findO1;
        boolean findO2;
        public Info(TreeNode ansNode, boolean findO1, boolean findO2){
            this.ansNode = ansNode;
            this.findO1 = findO1;
            this.findO2 = findO2;
        }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
