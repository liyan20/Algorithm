package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/12 16:30
 * @Title&Description: 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @Analysis:
 * 查找完全平方数。
 * 我觉得首先要对这个数找其最小的完全平方数，然后，减去再接着找，这样可能有问题吧
 * 换个想法：查找从这个数开始找完全平方数，然后递归找，如果不行，就换。有点像回溯啊感觉
 * @Summary:
 * @TimeConsuming:
 */
public class Code279_PerfectSquares_0712_3 {
    public static void main(String[] args) {
        double a = Math.sqrt(9);
        System.out.println(a == (int)a);
    }
    public static int numSquares(int n) {
        if (n <= 0){
            return 0;
        }

    }

    //递归函数。
    public static int process(int rest){

    }

    public static int[] squareNumsList(int n){
        for (int i=n; n>=0; )
    }
}
