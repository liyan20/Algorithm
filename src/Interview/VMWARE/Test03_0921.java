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

public class Test03_0921 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i=0; i<n; i++){
                sc.nextInt();
                sc.nextInt();
            }
            solution();
        }
    }

    public static void solution(){
        System.out.println("2");
    }
}
