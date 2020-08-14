package Leetcode.BinarySearch;

/**
 * @Author: xianz
 * @Date: 2020/8/6 08:36
 * @Title&Description: 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * @Analysis:
 * 杨欢说这个首先是需要找到两个数组的中位数。根据计算，m+n数组的中位数是(m+n+1)/2和(m+n+2)/2。如果是奇数这两个是一样的
 * 如果是偶数这两个是中间那两个。我们就利用双指针，分别查找两个数组，找到第一个数，之后就是看两个是不是一样的
 * 如果是一样说明是奇数直接返回，如果不是的话就是偶数，再找下一个就行了。时间复杂度应该是o(m+n)
 * 杨欢说题目要求的o(log(m+n))是利用二分减少时间复杂度，先把不用二分的写出来。
 *
 * 二分查找
 * 对每个数组找其中位数。然后进行比较，比较小的那个数组的中位数的左边全部抛弃。原因如下：
 * 因为我们找的中位数是一个位置，假设是偶数，那么中位数是那个中间位置左边的最大值和右边的最小值。
 * 而我们对两个数组得到了两个数组的中位数，要找的是两个数组的左边的最大值，肯定两个数组较小的那个的左边是不能用的，
 * 因为小的数组的中位数比大的小，而小的数组的左边比小数组中位数小的，他们肯定不是中位数，因为他们比确定的两个中间的数都要小。
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_FindMedianSortedArrays_0806_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = (nums1.length + nums2.length - 1) / 2;
        int n2 = (nums1.length + nums2.length) / 2;
        int num1 = 0, num2 = 0;
        int p = 0, p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length && p <= n1){
            num1 = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            p++;
        }
        while(p1 < nums1.length && p <= n1){
            num1 = nums1[p1++];
            p++;
        }
        while(p2 < nums2.length && p <= n1){
            num1 = nums2[p2++];
            p++;
        }
        if(n1 == n2){
            return num1;
        }else{
            if(p1 >= nums1.length){
                num2 = nums2[p2];
            }else if(p2 >= nums2.length){
                num2 = nums1[p1];
            }else{
                num2 = Math.min(nums1[p1], nums2[p2]);
            }
            return (num1 + num2) / 2.0;
        }
    }
}
