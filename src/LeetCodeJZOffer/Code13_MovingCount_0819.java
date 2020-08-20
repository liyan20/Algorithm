package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 16:02
 * @Title&Description: 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code13_MovingCount_0819 {

    public int movingCount(int m, int n, int k) {
        int[][] isVisited = new int[m][n];
        return process(0,0,isVisited, m, n, k);
    }

    /**
     * 这个是递归主函数。i和j代表当前的位置，代表到了i,j的位置之后还有哪些位置可以到达。
     * @param i
     * @param j
     * @param isVisited
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int process(int i, int j, int[][] isVisited, int m, int n, int k){
        //越界等情况
        if(i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j] == 1 || (getDigitSum(i)+getDigitSum(j)) > k){
            return 0;
        }
        isVisited[i][j] = 1;  //这个地方很重要。虽然这里面置为1了，但是并没有将其置为0的代码。和回溯不一样
        int res = process(i+1, j, isVisited, m, n, k) + process(i, j+1, isVisited, m, n, k) + 1;
        return res;
    }

    public static int getDigitSum(int n){
        int res = 0;
        while(n > 0){
            res += n % 10;
            n /= 10;
        }
        return res;
    }

}
