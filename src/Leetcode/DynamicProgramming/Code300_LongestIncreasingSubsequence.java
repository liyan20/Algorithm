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
        int res = 0;
        //每一个i是指的以i结尾的必须包括i的位置的串。
        //针对每一个i，要有看前面所有的nums[i]>nums[j]的情况，找到最大的那个然后+1。这个是dp[i]的结果
        //表明了第i个数比之前哪些大，这样就在前面的基础上面加上1就行了。最终输出结果是以所有的i结尾的最大值就行。
        for (int i=1; i<nums.length; i++){
            int max = 0;
            for (int j=0; j<i; j++){
                if (nums[i] >= nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
