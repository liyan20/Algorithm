package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/10 09:25
 * @Title: 两数之和
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Analysis: 1.两个整数的和，只有两个，如果是正常想法，就是双重循环，这样可能会超时。这居然能过
 * 2.使用hashmap，hashmap查询速度快，这样只需要遍历一次。数组是index对应value，看题意不会重复，那么可以用hashmap的value对应index
 * @ThinkingSteps:
 * @TimeConsuming: 15min
 */
import java.util.*;
public class Question08_0510_2 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        for(int num:twoSum(nums, 6)){
            System.out.println(num);
        }
    }
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] out = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp) && map.get(temp)!=i){
                out[0] = i;
                out[1] = map.get(temp);
                break;
            }
        }
        return out;
    }


    public static int[] twoSum2(int[] nums, int target) {
        int num1=0;
        int num2=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    num1 = i;
                    num2 = j;
                }
            }
            if(num1!=num2){
                break;
            }
        }
        int[] out = {num1,num2};
        return out;
    }
}
