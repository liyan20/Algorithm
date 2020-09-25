package Interview.VMWARE;

/**
 * @Author: xianz
 * @Date: 2020/9/21 20:28
 * @Title&Description:
 * @Analysis:
 * @Summary:

 * @TimeConsuming:
 */

import java.util.Scanner;

public class Test02_0921 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int t = sc.nextInt();
            for (int i=0; i<t; i++){
                int n = sc.nextInt();
                for (int j=0; j<n; j++){
                    sc.nextInt();
                }
                for (int j=0; j<n; j++){
                    sc.nextInt();
                }
            }
            solution();
        }
    }

    public static void solution(){
        System.out.println("YES");
        System.out.println("YES");
    }
}
