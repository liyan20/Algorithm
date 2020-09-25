package Interview.QUNAER;

/**
 * @Author: xianz
 * @Date: 2020/9/23 19:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test02_0923 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            solution(s1, s2);
        }
    }

    public static void solution(String s1, String s2){

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int[][] dp = new int[arr1.length][arr2.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = arr1[i].equals(arr2[j]) ? 1 : 0;
                }else if (i == 0 && j != 0){
                    dp[i][j] = arr1[i].equals(arr2[j]) ? 1 : dp[i][j-1];
                }else if (i != 0 && j == 0){
                    dp[i][j] = arr1[i].equals(arr2[j]) ? 1 : dp[i-1][j];
                }else {
                    if (!arr1[i].equals(arr2[j])){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

}
