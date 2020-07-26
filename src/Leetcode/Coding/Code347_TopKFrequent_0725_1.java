package Leetcode.Coding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: xianz
 * @Date: 2020/7/25 08:51
 * @Title&Description: 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * @Analysis:
 * 不管怎么说，先用一个hashmap记录一下频率吧，时间是o(n)
 * 前K个高频元素，其实就是一个小根堆就行了。和求最大的K个数是一样的。
 * @Summary:
 * @TimeConsuming:
 */
public class Code347_TopKFrequent_0725_1 {
    public static int[] topKFrequent(int[] nums, int k) {
        //用hashmap保存词频
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int cur = nums[i];
            if (!map.containsKey(cur)){
                map.put(cur, 1);
            }else {
                map.put(cur, map.get(cur)+1);
            }
        }
        //建立小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        //堆的元素是数组内容，堆的排序依据是数组内容的词频
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if (priorityQueue.size() < k){
                priorityQueue.offer(key);
            }else {
                if (value > map.get(priorityQueue.peek())){
                    priorityQueue.poll();
                    priorityQueue.offer(key);
                }
            }
        }
        int[] res = new int[k];
        for (int i=k-1; i>=0; i--){
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
