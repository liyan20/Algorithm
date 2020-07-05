package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/5 16:44
 * @Title&Description:
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * @Analysis:
 * 这题其实就是一个快速排序的partition的过程，把1当成是p就行
 * @Summary:
 * @TimeConsuming:
 */
public class Code75_SortColors_0705_5 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1, 1);
    }

    public static void partition(int[] nums, int L, int R, int p){
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (index < more){
            if (nums[index] < p){
                //至于这边为什么i可以++而下面的不行，是因为在i左边的都是已经判断过的
                //都是小于等于p的，已经判断过了，所以不需要判断。下面的是和i右边的交换，
                // 是多大的数都有可能，所以i不能直接++
                swap(nums, index++, ++less);
            }else if (nums[index] > p){
                swap(nums, index, --more);
            }else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
