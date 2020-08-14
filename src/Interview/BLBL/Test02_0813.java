package Interview.BLBL;

/**
 * @Author: xianz
 * @Date: 2020/8/13 19:46
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0813 {

    public int minPathSum (int[][] grid) {
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
                }else if (i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


}
