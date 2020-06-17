package Leetcode_EasyAlgorithm.Dynamic_Programming;

/**
 * @Author: xianz
 * @Date: 2020/5/17 08:42
 * @Title&Description: 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Analysis: 方法1：自己想出来的方法。从0开始判断，设数组为nf0=0，f1=n1。这都正常。
 * 从2开始，这里面的2是前2个数的最大值，而不是包括了第二个。
 * 2开始，有两种情况，要不然是不要第二个只要第一个，因为不能连着，要不然是去掉第一个，要第二个，即为f1和f0+n2两种情况
 * 3开始，要不然是要f1+n3，要不然是只要f2
 * 4开始，要不然是要f2+n4，要不然是f3
 * so，f(i) = max{f(i-1), f(i-2)+n[i]}，f(1)=n[1],f(0)=0
 *
 * 我的方法要不然是隔着一个取，要不然是隔着两个取。看哪个大。
 * 可能有人会问，为什么不能隔着三个取，那这样的话，隔着3个其实相当于是隔着一个再隔着一个，
 * 这样肯定没有两个隔着一个多的，因为都是非负的情况，所以这里面只有两种可能，要不然隔着一个取，要不然隔着两个取
 * 这里面有
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question04_0517_1 {
    public static void main(String[] args) {
        int[] nums = {3,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<nums.length+1;i++){
            int curValue = nums[i-1];
            dp[i] = Math.max(dp[i-1],dp[i-2]+curValue);
        }
        return dp[dp.length-1];
    }
}
