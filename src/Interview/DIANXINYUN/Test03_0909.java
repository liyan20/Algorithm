package Interview.DIANXINYUN;

/**
 * @Author: xianz
 * @Date: 2020/9/9 20:54
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Test03_0909 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(solution(s));
        }
    }

    public static int solution(String s){
        String[] strArr = s.split(",");
        int[] arr = new int[strArr.length];
        for (int i=0; i<strArr.length; i++){
            arr[i] = Integer.valueOf(strArr[i]);
        }
        int[] dp = new int[arr.length];
        if (arr.length == 1){
            return arr[0];
        }
        if (arr.length == 2){
            return Math.max(arr[0], arr[1]);
        }
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i=2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[dp.length - 1];
    }

}
