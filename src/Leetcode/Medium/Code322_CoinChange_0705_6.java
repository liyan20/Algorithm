package Leetcode.Medium;

import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/7/5 21:14
 * @Title&Description: 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code322_CoinChange_0705_6 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 100;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1){
            return -1;
        }
        int[] cache = new int[amount+1];
        for (int i=0; i<cache.length; i++){
            cache[i] = Integer.MAX_VALUE;
        }
        return process(amount, coins, cache);
    }

    //递归函数，动态规划
    //这里面有问题，之前那个问题是问有几种情况，所以所有的硬币都必须考虑到，就需要index参数
    //这里面的递归函数求的是：当前还剩下rest的钱，最少需要多少硬币。所以参数里面不应该有目前的钱
    //或者有的话我的cache参数应该是二维的才对。这样有问题，因为我不知道要的钱的边界是什么，违反
    // 了左神的规则，不知道边界，直接去掉当前已经的数量的nums参数，让递归函数返回
    public static int process(int rest, int[] coins, int[] cache){
        //base case。rest<0表示这个递归函数走不通，返回-1表示不行。因为硬币数量不可能是负数
        if (rest < 0){
            return -1;
        }
        if (cache[rest] != Integer.MAX_VALUE){
            return cache[rest];
        }
        //还是0元的钱，当然不需要硬币了，直接返回nums
        if (rest == 0){
            cache[rest] = 0;
            return 0;
        }
        //这个循环里面每个硬币只要一个，看看下面剩下的接着递归
        //然后要选择剩下这i种选择里面最小的那个
        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            int res = process(rest - coins[i], coins, cache);
            if (res >= 0){
                min = Math.min(min, res + 1);
            }
        }
        cache[rest] = min == Integer.MAX_VALUE ? -1 : min;
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
