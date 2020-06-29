package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/29 15:46
 * @Title&Description: 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code15_3sum_0629_3 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            //这段的目的是防止重复的情况。
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int k = nums.length - 1;
            for (int j=i+1; j<nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                //个人觉得这个就应该是双指针吧，只不过是前后的那种双指针
                List<Integer> list = new ArrayList<>();
                while (k > j && (nums[i] + nums[j] + nums[k] > 0)){
                    k--;
                }
                //这时候有个问题了，有可能是k<=j了，这时候j再往下加已经没有意义了
                if (k == j){
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
