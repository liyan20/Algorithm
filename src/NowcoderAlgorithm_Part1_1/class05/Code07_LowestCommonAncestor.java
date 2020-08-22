package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/7 10:01
 * @Title&Description: 求二叉树的最低公共祖先
 * 0.以x为结点的情况下，他的最低公共祖先有哪些情况？
 * 1）既无o1，也无o2，在x上不存在
 * 2）x只含o1或者只含o2，x不存在最大公共祖先
 * 3）o1和o2都在x树上：
 * 情况1：左树有一个，右树一个，那x就是答案；
 * 情况2：都在左树，答案是左树的最大公共祖先；
 * 情况3：都在右树，答案是右树的最低公共祖先
 * 1.Info类信息：是否已经发现最低公共祖先，Node或null；是否发现o1；是否发现o2
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_LowestCommonAncestor {
    public static void main(String[] args) {

    }

    //代表这个以x为根节点的树，是否发现o1，是否发现o2，是否找到了o1和o2的最低公共祖先，找到了就是TreeNode，没找到就是null
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

        //下面的两个只会执行一个或者都不执行，因为最低公共祖先只有一个，不可能同时出现在左树和右树上面
        if(leftInfo.fineAns != null){
            return new Info(leftInfo.fineAns, true, true); //返回的是左树的最低公共祖先，因为是要求最低，所以递归回去。
        }
        if(rightInfo.fineAns != null){
            return new Info(rightInfo.fineAns, true, true);
        }

        //如果o1和o2分别在左右树或者右左树，那么x就是最低公共祖先。
        if ((leftInfo.findO1 && rightInfo.findO2) || (leftInfo.findO2 && rightInfo.findO1)){
            return new Info(x, true, true);
        }

        //左右子树要不是只有o1，要不是只有o2，要不是两个都没有。下面的是条件2的情况，存在一个
        //但是x本身是不是o1和o2需要考虑

        //左右两树都没有最低公共祖先，并且最低公共祖先不在x处交汇。
        //所以是整个树只包含o1或者只包含o2或者都不包含
        //这里面因为左右子树的判断其实不包含x本身，所以要判断x本身是不是o1或者o2的情况
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
