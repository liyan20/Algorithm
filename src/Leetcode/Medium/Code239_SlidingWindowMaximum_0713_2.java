package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/13 20:38
 * @Title&Description: 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @Analysis:
 * 使用双端队列，存放的是数组的下标
 * 滑动窗口的左右下标L和R。
 * 如果L向右移动，如果双端队列里面存在之前的这个L，就把这个下标从头部弹出，如果不存在，就不用管；
 * 如果R向右移动，如果双端队列里面队尾的数比移动后的R小或者等于，就拿出来，直到队尾的数严格大于目前的R
 * 的数，之后把R的数放进队尾。
 * L就是弹出队头，R就是放入队尾。
 * R移动的时候，必须严格大于，因为如果是等于，放进去的新的R肯定是在下标上面大于里面的那个相等的的，
 * 所以L右移的时候，如果不拿出来不放进去，就会出现删掉了这个数导致双端队列为空的情况。
 * @Summary:
 * @TimeConsuming:
 */
public class Code239_SlidingWindowMaximum_0713_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k){
            return new int[0];
        }
        Deque<Integer> qmax = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];  //数学计算，窗口长度为k的情况下能划几次
        int index = 0;
        //这个题目比较固定，就是L和R分布向右滑动一下
        for (int i=0; i<nums.length; i++){
            //R向右滑动，先把队尾所有小于等于nums[i]的给扔掉，之后把nums[i]放进去
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){
                qmax.pollLast();
            }
            qmax.offerLast(i);
            //L向右滑动。如果目前队头的还是L没动之前那个位置，就把他删掉。
            //如果不是，说明之前放R那个数的时候已经扔过了，就不用动了
            if (qmax.peekFirst() == i - k){
                qmax.pollFirst();
            }
            //当k长度的滑动窗口建立完毕的时候，开始保存需要的结果
            if (i >= k - 1){
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
