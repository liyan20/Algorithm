package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/9 09:23
 * @Title: 存在重复元素
 * @Description: 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * [1,2,3,4]
 * 输出: false
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming: 5min
 */
import java.util.*;
public class Question04_0509_2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            if(set.size() != i+1){
                return true;
            }
        }
        return false;
    }
}
