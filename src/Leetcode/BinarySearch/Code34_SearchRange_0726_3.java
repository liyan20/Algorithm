package Leetcode.BinarySearch;

/**
 * @Author: xianz
 * @Date: 2020/7/26 21:02
 * @Title&Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @Analysis:
 * 要求o(logn)，那只能是二分。
 * 求两个边界的时候，需要的是分开进行求解。核心在于相等的时候不反悔。
 * 针对，左边界，相等的时候继续向左找，即R=mid-1，和大于的时候一样。
 * 注意，每次的查找都是mid减一或者加一，不是Mid.
 * 左边界的话，每次找，知道L比R还大的时候，就返回。这时候因为左边界，最终我们想要L和R在一块差1才结束的
 * 所以左边界每次都是R向左，这样如果有一次遇到了左边界，左边界相等于target，这时候R还是左移的一位。
 * 但是是排序数组，左边的肯定比右边的小，这样下面每次循环都是L要向右而R是不变的，直到L大于R的时候，就是L是左边界。
 * 同理右边界是L在向右收缩的，直到L到了右边界，他还是+1，之后R开始移动，直到R<L结束，R是结果。
 * 有两个注意点，就是可能找不到的情况。就是每个数都比target大或者都比target小的情况。这时候可能会越界。
 * 如果到时候不明白，就画个图就行。
 * @Summary:
 * @TimeConsuming:
 */
public class Code34_SearchRange_0726_3 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        for (int i : res){
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1 || target < nums[0] || target > nums[nums.length-1]){
            return new int[] {-1, -1};
        }
        int L = 0, R = nums.length - 1;
        int mid = 0;
        int s1 = 0, s2 = 0;

        //查找左边界，R向左收缩
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if (nums[mid] < target){
                L = mid+1;
            }else if (nums[mid] > target){
                R = mid-1;
            }else if (nums[mid] == target){
                R = mid-1;
            }
        }
        //越界情况：R向左收缩越界；R是向左移动的，但我们想要的结果是L所以不需要管R的事情
        //有一种情况就是所有的数比target小的情况，搜索完了结果找不到之后L就出去了
        //还有一种就是真的找不到的情况，那时候就是L和R在数组内部找不到就L>R结束循环。
        //最终都是要判断我们想要的这个L是不是等于target，或者L数组越界
        if (L > nums.length - 1 || nums[L] != target){
            return new int[] {-1, -1};
        }else {
            s1 = L;
        }

        //查找右边界，L向右收缩
        L = 0;
        R = nums.length - 1;
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if (nums[mid] < target){
                L = mid+1;
            }else if (nums[mid] > target){
                R = mid-1;
            }else if (nums[mid] == target){
                L = mid+1;
            }
        }
        //越界情况：L向右收缩越界；L是向右移动的，R是最终的可能结果，因为L在等于target右边界之后会+1
        //这样之后就L就呆在这不动了，等R向左来，因为是排序数组，R总要向左移动的
        if (L < 0 || nums[R] != target){
            return new int[] {-1, -1};
        }else {
            s2 = R;
        }
        return new int[] {s1, s2};
    }
}
