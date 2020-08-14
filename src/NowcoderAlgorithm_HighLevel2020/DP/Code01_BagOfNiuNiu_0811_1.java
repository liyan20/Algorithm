package NowcoderAlgorithm_HighLevel2020.DP;

/**
 * @Author: xianz
 * @Date: 2020/8/11 11:16
 * @Title&Description: 题目描述
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 * 示例1
 * 输入
 * 复制
 * 3 10
 * 1 2 4
 * 输出
 * 复制
 * 8
 * 说明
 * 三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Code01_BagOfNiuNiu_0811_1 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int capacity = sc.nextInt();
            int[] v = new int[n];
            for (int i=0; i<n; i++){
                v[i] = sc.nextInt();
            }
            System.out.println(getNum(v, capacity));

        }
    }

//    public static void main(String[] args) {
//        int capacity = 100000000;
//        int[] v = {1,2,4};
//        System.out.println(getNum(v, capacity));
//    }

    //必须得是long格式，要不然会超Int，淦，又是这种问题。
    public static long getNum(int[] v, int capacity){
        long sum = 0;
        for (int temp : v){
            sum += temp;
        }
        //如果加起来都不够，那么就是每个零食放或者不放，2^n种。
        //不加这个只能过80%的测试用例，服了
        if (sum < capacity){
            return (long)(Math.pow(2, v.length));
        }
        return process(0, capacity, v);
    }

    /**
     *
     * @param index index代表从arr[index ..]的范围内找
     * @param rest rest代表还剩下多少容量。
     * @param v
     * @return
     */
    public static long process(int index, int rest, int[] v){
        if(rest < 0){
            return -1;
        }
        if(index == v.length){
            return 1;
        }
        long next1 = process(index + 1, rest, v);
        long next2 = process(index + 1, rest - v[index], v);
        return next1 + (next2 == -1 ? 0 : next2);
    }

    /**
     * 动态规划的方法。两个参数，index的位置，还有就是剩余的容量。
     * base case，还剩下0的容量的时候，dp的值应该是0
     * @param v
     * @param capacity
     * @return
     * 但是有了问题，dp的方法会超内存，只能通过20%的数据。
     */
    public static long getNumDP(int[] v, int capacity){
        if (v == null || capacity < 0){
            return 0;
        }
        long[][] dp = new long[v.length + 1][capacity + 1];
        for (int i=0; i<dp[0].length; i++){
            dp[dp.length-1][i] = 1;
        }
        for (int i=v.length-1; i>=0; i--){
            for (int j=0; j<dp[0].length; j++){
                long next1 = dp[i+1][j];
                long next2 = j-v[i] < 0 ? 0 : dp[i+1][j-v[i]];
                dp[i][j] = next1 + next2;
            }
        }
        return dp[0][capacity];
    }
}
