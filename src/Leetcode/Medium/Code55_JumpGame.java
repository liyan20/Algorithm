package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/27 12:46
 * @Title&Description: 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @Analysis:
 * 先写递归吧
 * @Summary:
 * @TimeConsuming:
 */
public class Code55_JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        int[][] cache = new int[nums.length][nums.length];
        for (int i=0; i<cache.length; i++){
            for (int j=0; j<cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
        cache[nums.length-1][0] = 1;
        return process(nums, 0, nums.length - 1, cache) > 0;
    }

    public static int process(int[] arr, int index, int rest, int[][] cache){
        //这是越界的情况
        if (index >= arr.length || rest < 0){
            return 0;
        }
        //这是base case
        if (arr[index] >= rest){
            return 1;
        }
//        if (index == arr.length - 1){
//            return rest == 0 ? 1 : 0;
//        }
        //这是当前数为0的情况，防止死循环导致栈溢出
        if (arr[index] == 0 && rest != 0){
            return 0;
        }
        if (cache[index][rest] != -1){
            return cache[index][rest];
        }
        int res = 0;
        //当前的可以走arr[index]步，这是个枚举的问题
        for (int i=1; i<= arr[index]; i++){
            res += process(arr, index + i, rest - i, cache);
        }
        cache[index][rest] = res;
        return res;
    }
}
