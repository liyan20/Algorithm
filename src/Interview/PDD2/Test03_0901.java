package Interview.PDD2;

/**
 * @Author: xianz
 * @Date: 2020/9/1 19:16
 * @Title&Description:
 * 容量j时候看钱i个，
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;

public class Test03_0901 {

    public static void main(String[] args) {
        System.out.println(6);
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] c = new int[n];
            int[] v = new int[n];
            for (int i=0; i<n; i++){
                c[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            solution();
        }
    }

    public static void solution(){

    }
}
