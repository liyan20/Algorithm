package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 12:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code10_1_Fib_0819 {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[dp.length-1];
    }
}
