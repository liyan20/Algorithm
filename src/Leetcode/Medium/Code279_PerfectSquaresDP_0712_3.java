package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/12 17:06
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code279_PerfectSquaresDP_0712_3 {
    public static void main(String[] args) {
        System.out.println(numSquares(1));
    }

    public static int numSquares(int n) {
        if (n <= 0){
            return 0;
        }
        List<Integer> numsList = squareNumsList(n);
        int[] dp = new int[n+1];
        //base case
        dp[0] = 0;
        for (int i=1; i<dp.length; i++){
            int min = Integer.MAX_VALUE;
            for (int j=0; j<numsList.size(); j++){
                if (numsList.get(j) > i){
                    break;
                }
                min = Math.min(min, dp[i-numsList.get(j)] + 1);
            }
            dp[i] = min;
        }
        return dp[dp.length-1];
    }

    public static List<Integer> squareNumsList(int n){
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if (Math.sqrt(i) == (int)Math.sqrt(i)){
                list.add(i);
            }
        }
        return list;
    }
}
