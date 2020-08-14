package NowcoderAlgorithm_HighLevel2020.DP;

/**
 * @Author: xianz
 * @Date: 2020/8/12 08:05
 * @Title&Description: 题目描述
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * 输入描述:
 * 第一行输入两个整数 n 和 m，表示矩阵的大小。
 *
 * 接下来 n 行每行 m 个整数表示矩阵。
 * 输出描述:
 * 输出一个整数表示答案。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Code02_MinPathSum_0812_1 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(minPathSumDP(grid));
        }
    }

    /**
     * 递归解法，会超时
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null){
            return 0;
        }
        return process(grid.length-1, grid[0].length-1, grid);
    }

    /**
     * 表示从(0, 0)到(i, j)位置的最短路径。
     * @param i 当前位置i
     * @param j 当前位置j
     * @param grid
     * @return
     */
    public static int process(int i, int j, int[][] grid){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0){
            return -1;
        }
        //每个是来自于其左边和上边的。因为是向右和向下走的
        //所以我们选择两个里面比较小的那个就行。
        int from1 = process(i-1, j, grid);
        int from2 = process(i, j-1, grid);
        //额外判断一下是否是越界的情况，如果越界就不管越界的那个
        if (from1 != -1 && from2 != -1){
            return Math.min(from1, from2) + grid[i][j];
        }else {
            int max = Math.max(from1, from2);
            return (max == -1 ? 0 : max) + grid[i][j];
        }
    }

    /**
     * 动态规划解法。
     * @param grid grid遍历的坐标i,j指的是从0,0位置到i,j位置的最短路径
     * @return
     * 填写dp表的顺序是从上往下从左往右的。如果是在边界上面即i==0或者j==0的情况
     * 就只和左边或者上边的有关系，如果是中间的，就和左边和上面都有关系，选择一个最小值即可。
     * 因为每个位置只能从左边或者上面走过来，所以是选择小的那一个。，最终再加上当前位置的数即可
     */
    public static int minPathSumDP(int[][] grid) {
        if (grid == null){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if (i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0 && i != 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
