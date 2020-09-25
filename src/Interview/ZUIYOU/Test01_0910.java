package Interview.ZUIYOU;



/**
 * @Author: xianz
 * @Date: 2020/9/10 19:16
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test01_0910 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(solution(s));
        }
    }

    public static long solution(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<10; i++){
            map.put(i + "", i);
        }
        for (int i=10; i<36; i++){
            char cur = (char) ('a' + i-10);
            map.put(cur + "", i);
        }

        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (s.charAt(0) != '-' && !(Character.isDigit(cur) || Character.isLetter(cur))){
                return 0;
            }
        }

        long sum = 0;
        boolean isNegative = s.charAt(0) == '-';
        int index = isNegative ? 1 : 0;
        int power = s.length() - index - 1;
        for (; index<s.length(); index++){
            String cur = s.charAt(index) + "";
            sum += (long)map.get(cur) * (long)Math.pow(36, power);
            power--;
        }
        if (sum < 0){
            return isNegative ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return sum;
    }
}
