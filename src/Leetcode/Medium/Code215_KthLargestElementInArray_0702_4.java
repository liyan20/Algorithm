package Leetcode.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xianz
 * @Date: 2020/7/2 21:48
 * @Title&Description: 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @Analysis:
 * 使用大根堆，先放进去K个数，然后下面每一个数，比堆顶大的不管，小的放进去
 * 这样最后里面就是最小的K个。
 * 搞反了，问的是第k个最大的，就应该用小根堆，比堆顶大的放进去，小的不管
 * @Summary:
 * @TimeConsuming:
 */
public class Code215_KthLargestElementInArray_0702_4 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        //直接小根堆完事
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i=0; i<k; i++){
            priorityQueue.offer(nums[i]);
        }
        //大于堆顶的放进去，小于的不放。等于号的话，应该不重要吧
        //大于的放进去，里面剩下的就是k个最大的数。第一个就是K个里面最小的，就是整体第K大的
        for (int i=k; i<nums.length; i++){
            if (nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
}
