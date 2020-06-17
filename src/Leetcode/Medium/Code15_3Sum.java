package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/12 09:06
 * @Title&Description: 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @Analysis: 使用之前的两数之和的方法。既然是a+b+c=0，那就换成a + b = -c，把-c当成target
 * @Summary:
 * @TimeConsuming:
 */
public class Code15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> listAll = new ArrayList<>();
//        if (nums == null){
//            return listAll;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i=0; i<nums.length; i++){
//            map.put(nums[i], i);
//        }
//        List<Integer> list = new ArrayList<>();
//        int target = 0;
//        for (int i=0; i<nums.length; i++){
//            target = nums[i];
//            for (int j=0; j<nums.length; j++){
//                list.clear();
//                if (j != i && map.containsKey(target - nums[j]) && map.get(target - nums[j]) != j){
//                    list.add(target);
//                    list.add(nums[j]);
//                    list.add(map.get(target - nums[j]));
//                    listAll.add(list);
//                }
//            }
//        }
//        return listAll;
//    }

}
