package Leetcode.Search_DynamicPrograming;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/7/27 18:44
 * @Title&Description: 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code322_CoinChange_0727_3 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount){
        if (coins == null || coins.length < 1){
            return 0;
        }
        int[] cache = new int[amount+1];
        Arrays.fill(cache, -1);
        int res = process(coins, amount, cache);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //递归函数，输出当然rest钱币的得到的最小值
    //这里面就是要求最小的钱数，最终是求钱的数量。所以返回的必然是钱的数量。
    //只需要一个参数，当前剩余钱数，之后对数组每一个金额，进行选择，每次选择一个就行，
    // 之后剩下的交给下一个递归函数。返回之后加上1就是当前选择的那个。之后每次选择都可以返回一个数，
    // 进行求最小值即可。要注意的点就是返回值的时候可能会越界的情况。
    public static int process(int[] coins, int rest, int[] cache){
        //rest小于0说明越界了，返回-1，下面要注意-1的问题
        if (rest < 0){
            return -1;
        }
        //rest为0说明没有需要凑得钱了，不需要钱了，直接返回0
        if (rest == 0){
            cache[rest] = 0;
            return 0;
        }
        if (cache[rest] != -1){
            return cache[rest];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            //这里面有可能返回的是Integer.MAX_VALUE + 1等于负数，直接在下面不判断了
            int res = process(coins, rest-coins[i], cache) + 1;
            if (res > 0){
                min = Math.min(min, res);
            }
        }
        cache[rest] = min;
        return min;
    }
}
