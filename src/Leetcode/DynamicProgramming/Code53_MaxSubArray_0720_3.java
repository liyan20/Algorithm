package Leetcode.DynamicProgramming;

/**
 * @Author: xianz
 * @Date: 2020/7/20 20:09
 * @Title&Description: 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Analysis:
 * 解构题目要求：
 * 要求的是最大连续子数组，我们一般动态规划或者递归都有一个index代表是数组的位置。这个要求的是和而不是具体哪些数，
 * 而子数组必然有一个终止的位置，所以就可以计算在第index位置终止的子数组的和dp[i]，找到最大的那个。
 * 典型的动态规划。自底而上的方法。设dp[i]是代表以第i个数截止的最大和，
 * 此时就是如果dp[i-1]是正数，那就加上第i位的数，如果是负数就弄成0再加上i的数。
 * 其实就是如果是正数，加上i位置的数会更大，如果是负数就直接不要前面的了，
 * 因为i位置的数加上一个负数肯定比不加要小。这个感觉递归就不是很好写了，直接动态规划。
 * @Summary:
 * @TimeConsuming:
 */
public class Code53_MaxSubArray_0720_3 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        if (nums == null || nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            if (dp[i-1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
