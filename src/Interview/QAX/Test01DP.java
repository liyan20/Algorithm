package Interview.QAX;
/**
 * @Author: xianz
 * @Date: 2020/8/1 15:36
 * @Title&Description:
 * 应该是一个完全背包问题
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Arrays;
import java.util.Scanner;

public class Test01DP {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int money = sc.nextInt();
//            int num = sc.nextInt();
//            int[] prices = new int[num];
//            int[] values = new int[num];
//            for (int i=0; i<num; i++){
//                prices[i] = sc.nextInt();
//                values[i] = sc.nextInt();
//            }
//            System.out.println(maxValue(money, prices, values));
//        }
//    }

    public static void main(String[] args) {
        int money = 20;
        int[] prices = {77,22,29,50,99};
        int[] values = {92,22,36,46,90};
        System.out.println(maxValue(money, prices, values));
    }

    public static int maxValue(int money, int[] prices, int[] values){
        int[] cache = new int[money+1];
        Arrays.fill(cache, Integer.MIN_VALUE);
        return process(money, prices, values, cache);
    }

//    dp[i] = dp[i-p1 * k] + ;k* v

    //已经的有的收益在递归的函数体内
    public static int process(int rest, int[] prices, int[] values, int[] cache){
        if (rest < 0){
            return -1;
        }
        if (rest == 0){
            cache[rest] = 0;
            return 0;
        }
        if (cache[rest] != Integer.MIN_VALUE){
            return cache[rest];
        }
        int max = 0;
        for (int i=0; i<prices.length; i++){
            int res = process(rest - prices[i], prices, values, cache);
            if (res != -1){
                max = Math.max(max, res + values[i]);
            }
        }
        cache[rest] = max;
        return max;
    }
}
