package Interview.TigerJT;

/**
 * @Author: xianz
 * @Date: 2020/8/16 16:56
 * @Title&Description:
 * 最短路径和
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0816 {

    public int uniquePaths (int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = arr[i][j];
                }else if (i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                }else if (i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else if (i != 0 && j != 0){
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
