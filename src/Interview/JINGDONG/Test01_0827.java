package Interview.JINGDONG;

/**
 * @Author: xianz
 * @Date: 2020/8/27 19:39
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0827 {

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

    public static void solution(int num){
        int n = reverse(num);
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            sb.append(n % 5);
            n /= 5;
        }
        System.out.println(sb.reverse().toString());
    }

    public static int reverse(int n){
        StringBuilder sb = new StringBuilder(n + "");
        sb = sb.reverse();
        while (sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return Integer.valueOf(sb.toString());
    }


}
