package Leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/7/16 09:25
 * @Title&Description: 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        //dp转移方程：dp[i]是以第i位结尾的最大值。要看前面的数值，如果第i位数比前面的大，就在其上面+1
        //说明子串包括i，因为是大于前面的所以是递增子串，之后就是找到最大的就行。
        //比如[2,5,3,7]里面2是1，就是自己，5是2代表25，3是2代表23，7就可以选择是27或者237,选个大的就行
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
