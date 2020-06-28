package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/28 22:57
 * @Title&Description: 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * @Analysis:
 * 方法1：暴力递归
 * 递归函数参数是当前的位置index，代表这次递归只用当前位置的钱的金额。还有一个是剩余要达到的钱数。
 * 是一种经典的从前往后选择的递归方法
 * @Summary:
 * @TimeConsuming:
 */
public class Code518_CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        if (coins == null || amount < 0){
            return 0;
        }
        int[][] cache = new int[coins.length+1][amount+1];
        for (int i=0; i<cache.length; i++){
            for (int j=0; j<cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
        return process(coins, 0, amount, cache);
    }

    public static int process(int[] arr, int index, int rest, int[][] cache){
        if (cache[index][rest] != -1){
            return cache[index][rest];
        }
        //base case。当index到头了。index范围是0 - arr.length-1的
        if (index == arr.length){
            return rest == 0 ? 1 : 0;
            //如果rest为0即不需要再搞钱了，就是1说明这种方案可行，如果不是0说明都到了
            //最后了钱还没够，这种方法肯定不行
        }
        //根据题意，每种金额的数量是不限制的，可以拿任意张，当然是不能超过总的金额数了
        //那就开始枚举
        //nums代表当前的金额的数量，数量不能超过总的当前递归需要的钱数，否则可以任意张
        int res = 0;
        for (int nums = 0; nums * arr[index] <= rest; nums++){
            res += process(arr, index + 1, rest - nums * arr[index], cache);
        }
        cache[index][rest] = res;
        return res;
    }
}
