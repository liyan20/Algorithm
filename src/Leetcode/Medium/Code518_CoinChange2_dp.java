package Leetcode.Medium;

import java.io.FileOutputStream;

/**
 * @Author: xianz
 * @Date: 2020/6/28 23:46
 * @Title&Description:
 * 可变参数是index当前位置，还有剩余的钱数rest
 * 先把表建立起来。但是问题来了，这个递归函数本身是需要枚举的，就是递归函数里面有一个for循环的
 * 所以填表都是从小的填到大的或者大的到小的的顺序来，所以直接用枚举在动态规划中是失效的。
 * 在本题中，我们发现每个位置是需要下面的位置然后加上下面左边的位置再加左边，每个地方间隔是当前的arr[index]
 * 分别代表的是用0张当前位置的金额，还有一张，两张等等。而左边的部分其实是等于当前位置同一行的左边间隔arr[index]的那个位置的
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code518_CoinChange2_dp {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];
        dp[N][0] = 1;  //到第N个时候rese为0就是1，因为index范围是0-N-1
        int[][] cache = new int[coins.length+1][amount+1];
        for (int i=N-1; i>= 0; i--){   //大顺序是从下往上的
            for (int rest=0; rest<=amount; rest++){
                dp[i][rest] = dp[i+1][rest];
                if (rest - coins[i] >= 0){  //如果左边的不越界，就可以直接加上，用这种方法来优化枚举
                    dp[i][rest] += dp[i][rest-coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
