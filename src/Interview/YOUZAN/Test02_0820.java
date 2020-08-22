package Interview.YOUZAN;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/8/20 19:39
 * @Title&Description:
 * 能被5整除的最大元素和
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0820 {

    public int maxSumDivFive (int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i=nums.length-1; i>=0; i--){
            sum += nums[i];
        }
        //dp[i][j]代表nums[0...i]上选择的对5取余等于j的最大值
        int[][] dp = new int[nums.length+1][5];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        dp[0][3] = Integer.MIN_VALUE;
        dp[0][4] = Integer.MIN_VALUE;
        for (int i=1; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (nums[i-1] % 5 == j){
                    for (int k=0; k<dp[0].length; k++){
                        dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k] + nums[i-1]);
                    }
                }
            }
        }
        return dp[dp.length-1][0];
    }

}
