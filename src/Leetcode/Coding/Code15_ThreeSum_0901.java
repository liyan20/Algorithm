package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/9/1 08:06
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code15_ThreeSum_0901 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int i=0,j=0,k=0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            j = i+1;
            k = nums.length-1;
            while(j < k){
                List<Integer> list = new ArrayList<>();
                if(j > i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k < nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                if(nums[j] + nums[k] + nums[i] < 0){
                    j++;
                }else if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else{
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    //这边十分重要。如果不是用for循环而是用while的话，要保证每一个if里面都是有j++的效果
                    //因为我们要保证考虑所有的情况，所有每次k都是最后的位置，j每次向右+1
                    j++;
                }
            }
        }
        return res;
    }
}
