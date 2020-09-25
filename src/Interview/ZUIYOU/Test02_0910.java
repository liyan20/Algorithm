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

public class Test02_0910 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        int num = 0;
        for (int i=0; i<n; i++){
            num += solution(i) * solution(n - i - 1);
        }
        return num;
    }
}
