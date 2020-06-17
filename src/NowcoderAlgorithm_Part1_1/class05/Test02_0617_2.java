package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/17 09:09
 * @Title&Description: 二叉树被记录成文件的过程叫做二叉树的序列化。序列化的方法有很多，
 * 这里我们采用括号序列的方法将其序列化，所谓括号序列指的是对于一个节点生成一个括号，
 * 括号内是其子树的括号序列，其中左儿子(若存在)的括号在前，右儿子(若存在)的括号在后。对于给定的树，请设计高效的算法，将其序列化。
 *
 * 给定一个树的根节点指针root，请返回一个字符串，代表其序列化后的括号序列。
 * @Analysis:
 * 这个看起来好像是把一个二叉树当成一个括号，比如1-2和3的三个结点的二叉树，最终应该是(() ())这种吧
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0617_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info{
        public String sequence;

        public Info(String sequence) {
            this.sequence = sequence;
        }
    }

    //简化版二叉树递归套路，在只有一个属性的情况下
    public String toSequence(TreeNode root){
        if (root == null){
            return "";
        }
        String leftSequence = toSequence(root.left);
        String rightSequence = toSequence(root.right);
        return "(" + leftSequence + rightSequence + ")";
    }
}
