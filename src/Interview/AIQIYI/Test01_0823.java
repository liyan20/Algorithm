package Interview.AIQIYI;

/**
 * @Author: xianz
 * @Date: 2020/8/23 15:17
 * @Title&Description: 正整数n的阶乘(n !)中的末尾有多少个0?
 *
 * 例如：n = 5, n! = 120.末尾有1个0
 *
 * 实现：int CountZero(int n);
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0823 {

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
        int res = 0;
        int cur = 0;
        for (int i=1; i<=n; i++){
            cur = i;
            while (cur % 5 == 0){
                res++;
                cur  = cur / 5;
            }
        }
        System.out.println(res);
    }

}
