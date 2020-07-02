package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/2 19:24
 * @Title&Description: 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @Analysis:
 * 目前想的是，遍历然后看最后能够跳到什么地方，如果是大于最终的位置，那就是可以的
 * 想的复杂了，一直想着用标准的递归来用，其实这样的话会时间复杂度会很多。
 * 方法：直接遍历，然后看 到了每一个位置后，当前最远的地方是在哪，说明能遍历到的地方是在哪
 * 当前最远位置是之前的最远的和现在的位置加上当前数组的值。
 * 如果当前的i不在当前最远位置上，就返回false
 * @Summary:
 * @TimeConsuming:
 */
public class Code55_JumpGame_0702_3 {
    public static void main(String[] args) {
        int[] arr1 = {3,2,1,0,4};
        int[] arr2 = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,
                2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,
                4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,
                0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(canJump(arr2));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1){
            return false;
        }
        int mostLength = 0;
        for (int i=0; i<nums.length; i++){
            if (i > mostLength){
                return false;
            }
            mostLength = Math.max(mostLength, i + nums[i]);
        }
        return true;
    }
}
