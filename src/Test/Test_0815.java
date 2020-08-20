package Test;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xianz
 * @Date: 2020/8/15 09:47
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test_0815{
    public static Deque<Integer> stackPush = new ArrayDeque<>();
    public static Deque<Integer> stackPoll = new ArrayDeque<>();

    public static void add(int x){
        pushToPoll();
        stackPush.offerFirst(x);
        pushToPoll();
    }

    public static int poll(){
        pushToPoll();
        return stackPoll.pollFirst();
    }

    public static int peek(){
        pushToPoll();
        return stackPoll.peekFirst();
    }

    public static void pushToPoll(){
        if(stackPoll.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPoll.offerFirst(stackPush.pollFirst());
            }
        }
    }

}