package Interview.PDD2;

/**
 * @Author: xianz
 * @Date: 2020/9/1 19:16
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0901 {

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
        int[][] arr = new int[n][n];
        int half = (n-1) / 2;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (i > 0 && i <= half && j > 0 && j <= half){
                    if (j > i){
                        arr[i][j] = 2;
                    }else if (j < i){
                        arr[i][j] = 3;
                    }
                }

                if (i > 0 && i <= half && j > half && j < n){
                    if (j-half-1 > i){
                        arr[i][j] = 2;
                    }else if (j < i){
                        arr[i][j] = 3;
                    }
                }

            }
        }
    }

    public static void process1(int n, int num){
        int[][] arr = new int[n/2][n/2];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (j > i){
                    arr[i][j] = 2;
                }else if (j < i){
                    arr[i][j] = 3;
                }
            }
        }
    }

    public static void process2(int n, int num){
        int[][] arr = new int[n/2][n/2];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (j >= i){
                    arr[i][j] = 1;
                }else if (j < i){
                    arr[i][j] = 3;
                }
            }
        }
    }

    public static void print(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (j < arr.length-1){
                    System.out.print(arr[i][j] + " ");
                }else {
                    System.out.print(arr[i][j]);
                    System.out.println();
                }
            }
        }
    }

}
