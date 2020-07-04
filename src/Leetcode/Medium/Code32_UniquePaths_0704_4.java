package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/4 17:32
 * @Title&Description: 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start”）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * @Analysis:
 * 这一题是属于动态规划的部分，我先用递归写一下。
 * @Summary:
 * @TimeConsuming:
 */
public class Code32_UniquePaths_0704_4 {
    public static void main(String[] args) {
        int m = 19, n = 13;
        System.out.println(uniquePaths_DP(m, n));
    }

    //动态规划的方法
    //1.几个参数就搞几维的表
    public static int uniquePaths_DP(int m, int n){
        int[][] dp = new int[m][n];
        //初始化即base case
        dp[m-1][n-1] = 1;
        //选取中间的情况，根据递归条件，是加上右边和下面的
        //其实就是从右往左从上而下加就行了
        for (int i=m-1; i >= 0; i--){
            for (int j=n-1; j >= 0; j--){
                if (i == m - 1 && j == n - 1){  //加一个判断，最后一个是不参与计算
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = getValue(dp, i+1, j) + getValue(dp, i, j+1);
                }
            }
        }
        return dp[0][0];
    }

    public static int getValue(int[][] arr, int i, int j){
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0){
            return 0;
        } else {
            return arr[i][j];
        }
    }

    public static int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i=0; i<cache.length; i++){
            for (int j=0; j<cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
        return process(0, 0, m, n, cache);
    }

    //主函数调用需要可变参数：当前位置，貌似就这一个，，
    public static int process(int i, int j, int m, int n, int[][] cache){
        //越界情况
        if (i >= m || j >= n || i < 0 || j < 0){
            return 0;
        }
        if (cache[i][j] != -1){
            return cache[i][j];
        }
        //base case
        if (i == m - 1 && j == n - 1){
            return 1;
        }
//        isVisited[i][j] = 1;
        int res = 0;
        res = res + process(i + 1, j, m, n, cache)
                + process(i, j + 1, m, n, cache);
        cache[i][j] = res;
        return res;
    }
}
