package Leetcode_EasyAlgorithm.Array;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/5/6 11:05
 * @Title:  删除排序数组中的重复项
 * @Description: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming: 45min
 */
public class Question01_0506_1 {
    public static void main(String[] args) {
        int[] nums = {-3,-1,0,0,0,3,3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static int removeDuplicates2(int[] nums){
        if(nums.length == 1){
            return 1;
        }else if(nums.length == 0){
            System.out.println(0);
        }
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return set.size();
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }else if(nums.length == 0){
            return 0;
        }
        int flag = 0;
        for(int i=0;i<nums.length;i++){
            int j = 0;
            for(j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    flag = nums[j];
                    break;
                }
            }
            if((j-i)!=1 && j!=nums.length){        //因为for循环里面的j++，循环出来之后都会比判断条件+1
                for(int k=i+1;k<j;k++){
                    nums[k] = flag;
                }
            }
        }
        int index = 0;
        for(int i=0;i<nums.length;i++){
            int last = nums[nums.length-1];
            if(nums[i] == last){
                index =  i+1;
                break;
            }
        }
        return index;
    }

}
