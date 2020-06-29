package Leetcode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/29 15:32
 * @Title&Description: 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Analysis:
 * 尝试一下双指针解法
 * 貌似双指针的前提是排序
 * 好像不能用双指针啊
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_TwoSum_0629_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,8,11,15};
        int target = 9;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
        }
        return res;
    }

    //双指针法返回的数值，因为排序后index会变乱，没法返回index
    public int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            int j = nums.length - 1;
            while (j > i && nums[i] + nums[j] > target){
                j--;
            }
            if (nums[i] + nums[j] == target){
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
        }
        return res;
    }
}
