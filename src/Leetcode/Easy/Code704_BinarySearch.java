package Leetcode.Easy;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/5/27 16:13
 * @Title&Description: 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code704_BinarySearch {
    public static void main(String[] args) {
//        int[] nums = {1,3,4,5,346,6,75,234};
        int[] nums = null;
        int target = 2;
        System.out.println(search(nums, target));
        System.out.println(Integer.toBinaryString(target & (~target+1)));
    }

    public static int search(int[] nums, int target) {
        if(nums==null || nums.length<1){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<=right){
            mid = left + (right-left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target<nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
