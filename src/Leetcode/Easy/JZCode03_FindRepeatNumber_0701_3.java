package Leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/7/1 20:59
 * @Title&Description: 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode03_FindRepeatNumber_0701_3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return nums[0];
    }
}
