package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/8/24 15:01
 * @Title&Description: 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code88_Merge_0824 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || m < 0 || n <= 0){
            return;
        }
        //m==0时，直接把第二个数组的复制过来就行了
        if(m == 0){
            for(int i=0; i<n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        //三个指针
        int p1 = m-1, p2 = n-1, p = m+n-1;
        //之后是谁大放在最后，然后指针向前移动
        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while(p1 >= 0){
            nums1[p--] = nums1[p1--];
        }
        while(p2 >= 0){
            nums1[p--] = nums2[p2--];
        }
    }

}
