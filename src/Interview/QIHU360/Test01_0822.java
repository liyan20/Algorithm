package Interview.QIHU360;

/**
 * @Author: xianz
 * @Date: 2020/8/22 19:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0822 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] arr = new String[n];
            for (int i=0; i<n; i++){
                arr[i] = sc.nextLine();
            }
            System.out.println(solution(arr));

        }
    }

    public static int solution(String[] arr){
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            if (isValid(arr[i])){
                sum++;
            }
        }
        return sum;
    }

    public static boolean isValid(String str){
        int sum = 0;
        for (int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            if (Character.isLetter(cur)){
                sum++;
            }
        }
        return sum == str.length() && str.length() <= 10;
    }
}

