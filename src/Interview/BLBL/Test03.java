package Interview.BLBL;

/**
 * @Author: xianz
 * @Date: 2020/8/13 19:55
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test03 {

    public static void main(String[] args) {
        int[] arr = {1,2,8,3,5,7};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit (int[] prices) {
        if (prices == null || prices.length < 1){
            return 0;
        }
        int maxOnePart = getSingleMax(prices, 0, prices.length-1);

        //买两次的结果
        //i为第二次的起点。
        int maxTwoPart = Integer.MIN_VALUE;
        for (int i=2; i<prices.length - 1; i++){
            int maxLeft = getSingleMax(prices, 0, i-1);
            int maxRight = getSingleMax(prices, i, prices.length-1);
            maxTwoPart = Math.max(maxTwoPart, maxLeft + maxRight);
        }

        return Math.max(maxOnePart, maxTwoPart);
    }

    //单词的最大值
    public static int getSingleMax(int[] prices, int left, int right){
        if (prices == null || prices.length < 1){
            return 0;
        }
        int curMin = prices[left];
        int maxProfit = Integer.MIN_VALUE;
        int[] dp = new int[prices.length];
        for (int i=left; i<=right; i++){
            dp[i] = prices[i] > curMin ? prices[i] - curMin : 0;
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }

}
