package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/5 16:27
 * @Title&Description: 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @Analysis:
 * 方法：对于每个数，可以选择也可以不选择，这就是全排列
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code78_Subsets_0705_4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return res;
        }
        process(nums, 0, new ArrayList<>(), res);
        return res;
    }

    //关键在于这个选择的路径path，path代表着当前以及之前所有的选择的集合
    public static void process(int[] nums, int index, List<Integer> path, List<List<Integer>> res){
        //base case
        if (index == nums.length){
            res.add(path);
            return;
        }
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(nums[index]);  //index代表这个递归函数到了第几个数了
        process(nums, index + 1, path, res);
        process(nums, index + 1, newPath, res);
    }
}
