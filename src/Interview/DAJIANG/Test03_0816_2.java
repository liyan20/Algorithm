package Interview.DAJIANG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/8/16 20:30
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03_0816_2 {

    public static void main(String[] args) {
        test();
//        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            System.out.println(solution(s, k));
        }
    }

    public static void test(){
        String s = "71245323308";
        int k = 4;
        System.out.println(solution(s, k));
    }

    /**
     * 大概是需要保证剩下的第一位是最小的
     * 使用栈，在k的范围内弹出比较大的数字
     * @param s
     * @param k
     * @return
     */
    public static int solution(String s, int k){
        if (k == s.length()){
            return 0;
        }
        int deleteNum = 0;
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        for (i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            while (!stack.isEmpty() && stack.peekFirst() > cur && deleteNum < k){
                //如果比当前的数大，那肯定不能让他们在这个数的位置上，比如同样的位置肯定是3比7来的小
                stack.pollFirst();
                deleteNum++;
            }
            if (deleteNum >= k){
                break;
            }
            //入栈
            if (cur != '0'){
                stack.offerFirst(cur);
            }
        }
        while (deleteNum < k){
            stack.pollFirst();
            deleteNum++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        sb = sb.reverse();
        for (; i<s.length(); i++){
            sb.append(s.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
}
