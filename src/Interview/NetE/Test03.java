package Interview.NetE;

/**
 * @Author: xianz
 * @Date: 2020/8/8 16:08
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = getMethods();
            for (int i=0; i<n; i++){
                int cur = sc.nextInt();
                System.out.println(dp[cur]);
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(getMethods(5));
//    }

    public static int[] getMethods(){
        int[] dp = new int[100000];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            dp[i] = dp[i] % 10007;
        }
        return dp;
    }
}
