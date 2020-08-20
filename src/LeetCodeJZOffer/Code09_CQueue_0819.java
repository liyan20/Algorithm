package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 12:14
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code09_CQueue_0819 {
    public Deque<Integer> stackPush;
    public Deque<Integer> stackPoll;

    public Code09_CQueue_0819() {
        stackPush = new ArrayDeque<>();
        stackPoll = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        pushToPoll();
        stackPush.offerFirst(value);
    }

    /**
     * 每次处理之前都执行一遍pushToPoll()
     * @return
     */
    public int deleteHead() {
        pushToPoll();
        if(stackPoll.isEmpty()){
            return -1;
        }
        return stackPoll.pollFirst();
    }

    public int peek(){
        pushToPoll();
        if(stackPoll.isEmpty()){
            return -1;
        }
        return stackPoll.peekFirst();
    }


    /**
     * 当第二个栈为空的时候，把第一个栈所有的元素都放入第二个栈里面
     */
    public void pushToPoll(){
        if(stackPoll.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPoll.offerFirst(stackPush.pollFirst());
            }
        }
    }

}
