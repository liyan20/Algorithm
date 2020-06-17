package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/9 08:36
 * @Title: 旋转数组
 * @Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @Analysis: 1.先一个一个来，先看看旋转一个是什么情况 2.再根据k旋转k次就行了
 * @ThinkingSteps:
 * @TimeConsuming: 33min
 */

public class Question03_0509_1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        for(int i:nums){
            System.out.print(i);
        }
        rotate(nums, k);
        System.out.println();
        for(int i:nums){
            System.out.print(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k!=0){
            for(int j=0;j<k;j++){
                int temp = nums[nums.length-1];
                for(int i=nums.length-1;i>0;i--){
                    nums[i] = nums[i-1];
                }
                nums[0] = temp;
            }
        }
    }
}
