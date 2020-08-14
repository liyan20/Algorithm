package Leetcode.DynamicProgramming;

/**
 * @Author: xianz
 * @Date: 2020/8/5 09:45
 * @Title&Description: 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Analysis:
 * dp[i]代表第i天卖，那么只需要在前i-1天找到最小值就行。然后整个找个最小值。
 * @Summary:
 * @TimeConsuming:
 */
public class Code121_MaxProfit_0805_1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int curMin = prices[0];
        int max = 0;
        for (int i=1; i<dp.length; i++){
            dp[i] = prices[i] > curMin ? prices[i] - curMin : 0;
            curMin = Math.min(curMin, prices[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
