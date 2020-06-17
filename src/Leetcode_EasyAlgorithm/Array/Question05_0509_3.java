package Leetcode_EasyAlgorithm.Array;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/5/9 09:52
 * @Title: 只出现一次的数字
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1: 输入: [2,2,1] 输出: 1
 * 示例 2: 输入: [4,1,2,1,2] 输出: 4
 * @Analysis: 使用异或
 * @ThinkingSteps:
 * @TimeConsuming: 40min
 */
public class Question05_0509_3 {
    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
//        System.out.println(8^7^1^2^1^2^7);
        System.out.println(singleNumber2(nums1));
        System.out.println(singleNumber2(nums2));
    }
    public static int singleNumber1(int[] nums) {    //这个方法用到了排序，不符合线性时间复杂度
        Arrays.sort(nums);
        int num = 0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int i=0;i<nums.length-1;){
            if(nums[i] == nums[i+1]){
                i+=2;
            }else{
                num = nums[i];
                break;
            }
            if(i == nums.length-1){
                num = nums[i];
                break;
            }
        }
        return num;
    }
    public static int singleNumber2(int[] nums){
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num = num^nums[i];
        }
        return num;
    }
}
