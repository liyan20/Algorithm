package Interview.QUSHIKEJI;

/**
 * @Author: xianz
 * @Date: 2020/9/12 19:36
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;

public class Test02_0912 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String n = sc.nextLine();
            int x = Integer.valueOf(sc.nextLine());
            solution(n, x);
        }
    }

    /**
     * 应该是单调栈
     * @param n
     * @param x
     */
    public static void solution(String n, int x){
        if (n.length() == x){
            System.out.println(0);
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        //放入栈，保持递增的顺序即可
        for (int i=0; i<n.length(); i++){
            int cur = n.charAt(i) - '0';
            while (!stack.isEmpty() && cur <= stack.peekFirst() && x > 0){
                stack.pollFirst();
                x--;
            }
            stack.offerFirst(cur);
        }

        //删除剩下的即可
        while (x > 0){
            stack.pollFirst();
            x--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if (sb.length() == 1 && sb.charAt(0) == '0'){
            System.out.println(0);
            return;
        }
        System.out.println(sb.toString());
    }
}
