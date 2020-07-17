package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/15 18:12
 * @Title&Description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * @Analysis:
 * 这样分析。数组长度为N，这个数只能是在1-N+1之间
 * 我们将数组中所有小于等于 00 的数修改为 N+1N+1；
 * 我们遍历数组中的每一个数 xx，它可能已经被打了标记，因此原本对应的数为 |x|∣x∣，
 * 其中 |\,|∣∣ 为绝对值符号。如果 |x| \in [1, N]∣x∣∈[1,N]，
 * 那么我们给数组中的第 |x| - 1∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
 * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1N+1，否则答案是第一个正数的位置加 11。
 * @Summary:
 * @TimeConsuming:
 */
public class Test03_0715 {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++){
            if (nums[i] <= 0){
                nums[i] = nums.length+1;
            }
        }
        //这边是把位置给出现过的位置置负数，这样找就行了，比交换要强
        for (int i=0; i<nums.length; i++){
            if (Math.abs(nums[i]) <= nums.length && Math.abs(nums[i]) >= 1){
                nums[Math.abs(nums[i])-1] = -1 * Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
