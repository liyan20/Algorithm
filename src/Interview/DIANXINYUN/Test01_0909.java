package Interview.DIANXINYUN;

/**
 * @Author: xianz
 * @Date: 2020/9/9 20:54
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0909 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            solution(n);
        }
    }

    public static void solution(int n){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        long res = 0;
        while (n > 0){
            long cur = queue.poll();
            res = cur;
            if (!set.contains(cur * 2)){
                queue.add(cur * 2);
                set.add(cur * 2);
            }
            if (!set.contains(cur * 3)){
                queue.add(cur * 3);
                set.add(cur * 3);
            }
            if (!set.contains(cur * 5)){
                queue.add(cur * 5);
                set.add(cur * 5);
            }
            n--;
        }
        System.out.println(res);
    }

}
