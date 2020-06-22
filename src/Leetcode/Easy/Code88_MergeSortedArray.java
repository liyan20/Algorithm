package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/6/22 10:16
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
 * 正常的想法是建立一个新的数组，对于那两个，哪个小放在前面，然后接着考虑下面的
 * 方法2：
 * 既然nums1后面是空的，那我们就按照从大到小的顺序从右往左排。谁大放在右边。如果是放在左边的话，我一开始想的是把左边的
 * 给移动到右边和右边的0交换，后面发现不行，这样顺序会乱
 * @Summary:
 * @TimeConsuming:
 */
public class Code88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int temp : nums1){
            System.out.println(temp);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        if (nums1 == null || nums2 == null){
            return;
        }
        if (n == 0){
            return;
        }
        int cur = nums1.length - 1;
        while (m != 0 && n != 0){
            if (nums1[m - 1] > nums2[n - 1]){
                nums1[cur] = nums1[m - 1];
                cur--;
                m--;
            }else {
                nums1[cur] = nums2[n - 1];
                cur--;
                n--;
            }
        }
        while (m > 0){
            nums1[cur] = nums1[m - 1];
            cur--;
            m--;
        }
        while (n > 0){
            nums1[cur] = nums2[n - 1];
            cur--;
            n--;
        }
        if (cur >= 0){
            for (int i=0; i<length; i++){
                nums1[i] = nums1[i + cur];
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        if (arr[i] != arr[j]){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
