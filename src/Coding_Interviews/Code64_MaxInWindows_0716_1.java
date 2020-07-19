package Coding_Interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author: xianz
 * @Date: 2020/7/16 08:51
 * @Title&Description: 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code64_MaxInWindows_0716_1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1){
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        //i代表滑动窗口的新的R
        for (int i=0; i<num.length; i++){
            //R的操作
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            //L的操作。如果移动过后，窗口队列的第一个数还是移动前一位的那个数，就从队列里面踢掉
            if (queue.peekFirst() == i - size){
                queue.pollFirst();
            }
            if (i >= size - 1){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}
