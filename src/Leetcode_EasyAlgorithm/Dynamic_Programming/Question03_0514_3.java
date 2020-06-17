package Leetcode_EasyAlgorithm.Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/5/15 15:55
 * @Title&Description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Analysis: 方法1：设n为到第n-1个数的最大值为f(n-1)，则f(n)有两种，如果f(n-1)<0，那么就直接不要，f(n)=n
 * 为啥这样呢，因为如果前面的是负的，那我加上n肯定没有单独的n大啊，所以是这样。
 * 如果f(n-1)是正的，那么f(n)=f(n-1)+n。加上就完事了，可以用max来表示。这个自顶而下好像不好弄
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question03_0514_3 {
    public static void main(String[] args) {
        int[] list = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(list));
    }

    public static int maxSubArray(int[] nums) {
        //result数组的每个值代表了以i结尾的最大子序和
        int[] result = new int[nums.length];
        int max = nums[0];
        result[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            result[i] = Math.max(result[i-1]+nums[i],nums[i]);
            if(max<result[i]){
                max = result[i];
            }
        }
        return max;
    }
}
