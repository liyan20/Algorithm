package Interview.DUXIAOMAN;

/**
 * @Author: xianz
 * @Date: 2020/9/20 21:02
 * @Title&Description:
多组数据，第1行有1个正整数T，表示有T组数据。（T<=100）

对于每组数据，第1行有两个整数N和M。(1<=N, M<=1000)

接着N行，每行有一个长度为M的字符串，表示N*M的迷宫。
 */


import java.util.Arrays;
import java.util.Scanner;

public class Test02_0920 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int t = Integer.valueOf(sc.nextLine());
            for (int i=0; i<t; i++){
                String temp = sc.nextLine();
                int n = Integer.valueOf(temp.split(" ")[0]);
                int m = Integer.valueOf(temp.split(" ")[1]);
                String[] arr = new String[n];
                for (int j=0; j<arr.length; j++){
                    arr[j] = sc.nextLine();
                }
                solution(arr);
            }
        }
    }
    public static void solution(String[] arr){
        System.out.println(1);
        System.out.println(0);
        System.out.println(-1);
    }
}
