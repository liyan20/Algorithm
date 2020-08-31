package Leetcode.Tree;

/**
 * @Author: xianz
 * @Date: 2020/8/25 10:32
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

//最大路径和，可以是任意结点到任意结点
public class Code_maxPath2 {

    public static class Node {
        int value;
        public Node left;
        public Node right;
    }

    public static class Info {
        public int height;
        public int maxPathLength;  //整体的最大值

        public Info(int height, int maxPathLength) {
            this.height = height;
            this.maxPathLength = maxPathLength;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return null;
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        //高度很简单，左右子树最大的+1就行。因为可能不一定有子树，判断一下如果为空就是0
        int height = Math.max(leftInfo == null ? 0 : leftInfo.height,
                rightInfo == null ? 0 : rightInfo.height) + 1;

        //这是包含x的情况，因为比较容易写，先写这个。即左右子树的最大高度的和
        int maxPathLength = 1 + (leftInfo == null ? 0 : leftInfo.height) + (rightInfo == null ? 0 : rightInfo.height);

        //其他情况，左右子树的最大路径和取最大值。
        if (leftInfo != null){
            maxPathLength = Math.max(maxPathLength, leftInfo.maxPathLength);
        }

        if (rightInfo != null){
            maxPathLength = Math.max(maxPathLength, rightInfo.maxPathLength);
        }
        return new Info(height, maxPathLength);
    }
}
