package Leetcode.SlidingWindow_Stack;



/**
 * @Author: xianz
 * @Date: 2020/8/23 21:10
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayDeque;
import java.util.Deque;
public class Code739_DailyTemperatures_0823 {

    /**
     * 典型的单调栈算法。因为是求右边的最大值。所以是维护一个单调递减的栈。
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length < 2){
            return new int[] {0};
        }
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        /**
         * 当栈为空或者当前位置的数字小于等于栈顶的值时候，入栈。维持单调递减的单调栈
         * 当当前位置的数大于栈顶的时候，开始准备出栈。
         * 一个while循环，当栈顶的小于当前数的时候，出栈为cur，cur的右边第一个大的就是当前位置的数。
         * 这时候要接着循环，因为如果出来一个就把i放进去，不一定是单调栈。
         * 所以循环直到i可以放进去了，再放进去。
         * 最后外面遍历循环结束了，之后就是对栈里面还有元素的情况下，出栈，将其的值为0即可。
         *
         * 这题是求右边第一个大的距离，就是将index相减就行了。
         */
        for(int i=0; i<T.length; i++){
            if(stack.isEmpty() || T[i] <= T[stack.peekFirst()]){
                stack.offerFirst(i);
            }else{
                while(!stack.isEmpty() && T[i] > T[stack.peekFirst()]){
                    int curIndex = stack.pollFirst();
                    res[curIndex] = i - curIndex;
                }
                stack.offerFirst(i);
            }
        }
        while(!stack.isEmpty()){
            res[stack.pollFirst()] = 0;
        }
        return res;
    }
}
