package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/7 09:11
 * @Title: 买卖股票的最佳时机 II
 * @Description: 这题目要求时间连续，买新的股票必须卖掉手里面剩下的，那其实就是低估买入，高估卖出就行了
 * 不是说要只能买卖一次，一开始没明白以为只能选两个时间，现在就是遍历，找到每一个低估和他紧邻的高估的就行了
 * 并且是只能隔着两天卖，分两种情况：1.连续上涨，那么最后卖和隔一天买一次买一次结果是一样的
 * 2.先涨后跌然后再涨的更高，这种的结果是没有涨了就卖来得高的，比如是1-3-2-5，如果是只在最后卖就是5-1=4，如果隔天买卖就是3-1+5-2=5
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question02_0507_2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int currentPrice = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > currentPrice){    //如果当前的价格大于前一天的，就把利润加上去，同时currentPrice变成当前i的价格
                profit += prices[i] - currentPrice;
                currentPrice = prices[i];
            }else{                           //如果当前价格小于前一天的，就不做买卖，同时currentPrice也变成当前的价格，
                currentPrice = prices[i];     // 也就是当前天数指针+1
            }
        }
        return profit;
    }
}
