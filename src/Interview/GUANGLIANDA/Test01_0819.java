package Interview.GUANGLIANDA;

/**
 * @Author: xianz
 * @Date: 2020/8/19 18:46
 * @Title&Description: 跳舞机
 * 就是看看对应的字符串对不对就行
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0819 {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(solution(s1, s2));
        }
    }

    public static int solution(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() != s2.length()){
            return 0;
        }
        int sum = 0;
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(i)){
                sum += 20;
            }else {
                sum -= 10;
                sum = Math.max(sum, 0);
            }
        }
        return sum;
    }
}
