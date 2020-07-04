package NowcoderAlgorithm_Part1_1.class15;

/**
 * @Author: xianz
 * @Date: 2020/7/4 14:49
 * @Title&Description: 硬币兑换的方法数
 * 具体见leetcode medium 518
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code02_CoinsMin {
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
