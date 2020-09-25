package Interview.QUNAER;

/**
 * @Author: xianz
 * @Date: 2020/9/23 19:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0923 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            solution(m, n);
        }
    }

    public static void test(){
        solution(100,20);
    }

    public static void solution(int m, int n){
        if (n > m / 2){
            n = m - n;
        }
        long[][] dp = new long[m+1][n+1];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0){
                    dp[i][j] = 0;
                }else if (j == 0){
                    dp[i][j] = 1;
                }
            }
        }
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (i >= j){
                    if (i == j){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

}
