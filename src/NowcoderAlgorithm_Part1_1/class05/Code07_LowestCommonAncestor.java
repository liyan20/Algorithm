package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/7 10:01
 * @Title&Description: 求二叉树的最低公共祖先
 * 0.以x为结点的情况下，他的最低公共祖先有哪些情况？
 * 1）既无o1，也无o2，在x上不存在
 * 2）x只含o1或者只含o2，x不存在最大公共祖先
 * 3）o1和o2都在x树上：情况1：左树有一个，右树一个，那x就是答案；情况2：都在左树，答案是左树的最大公共祖先；情况3：
 * 都在右树，答案是右树的最低公共祖先
 * 1.Info类信息：是否已经发现最低公共祖先，Node或null；是否发现o1；是否发现o2
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public static class Info{
        TreeNode fineAns;
        boolean findO1;
        boolean findO2;
        public Info(TreeNode fineAns, boolean findO1, boolean findO2) {
            this.fineAns = fineAns;
            this.findO1 = findO1;
            this.findO2 = findO2;
        }
    }

    public static Info process(TreeNode x, TreeNode o1, TreeNode o2){
        if (x == null){
            return new Info(null, false, false);
        }
        Info leftInfo = process(x.left, o1, o2);
        Info rightInfo = process(x.right, o1, o2);
        //下面三个if是条件3的三种情况
        if(leftInfo.fineAns != null){
            return new Info(leftInfo.fineAns, true, true);
        }
        if(rightInfo.fineAns != null){
            return new Info(rightInfo.fineAns, true, true);
        }
        if ((leftInfo.findO1 && rightInfo.findO2) || (leftInfo.findO2 && rightInfo.findO1)){
            return new Info(x, true, true);
        }
        //左右子树要不是只有o1，要不是只有o2，要不是两个都没有。下面的是条件2的情况，存在一个
        //但是x本身是不是o1和o2需要考虑
        boolean findO1 = x == o1;
        boolean findO2 = x == o2;
        if(leftInfo.findO1 || rightInfo.findO1){
            if(findO2){
                return new Info(x, true, true);
            }else{
                return new Info(null, true, false);
            }
        }
        if (leftInfo.findO2 || rightInfo.findO2){
            if (findO1){
                return new Info(x, true, true);
            }else {
                return new Info(null, false, true);
            }
        }
        //最后是条件1的情况，都不存在
        return new Info(null, findO1, findO2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).fineAns;
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
