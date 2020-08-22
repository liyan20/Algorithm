package Interview.DIDI;

/**
 * @Author: xianz
 * @Date: 2020/8/21 19:49
 * @Title&Description: 小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。
 * 突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
 * 小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
 * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。
 * 第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 * 下面是n=4时的情况：
 * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 * 输入描述
 * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 * 输出描述
 * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 * @Analysis:
 * 3
 * 样例输出
 * 34 21 13
 * 1 1 8
 * 2 3 5
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0821 {

    public static void main(String[] args) {
        solution(4);
//        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            solution(n);
        }
    }

    public static void solution(int n){
        if (n == 1){
            System.out.println(1);
            return;
        }
        int[] fib = fib(n);
        for (int i=0; i<fib.length/2; i++){
            swap(fib, i, fib.length-1-i);
        }
        int[][] arr = new int[n][n];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                arr[i][j] = -1;
            }
        }
        int i = 0, j = 0;
        arr[0][0] = fib[0];
        for (int index=1; index<n * n; index++){
            if ((j+1 < n && arr[i][j+1] == -1) && (i+1 < n && arr[i+1][j] == -1)){
                j++;
                arr[i][j] = fib[index];
                continue;
            }
            if (!(j+1 < n && arr[i][j+1] == -1) && (i+1 < n && arr[i+1][j] == -1)){
                i++;
                arr[i][j] = fib[index];
                continue;
            }
            if ((i+1 < n && arr[i+1][j] == -1) && (j-1 >= 0 && arr[i][j-1] == -1)){
                i++;
                arr[i][j] = fib[index];
                continue;
            }
            if (!(i+1 < n && arr[i+1][j] == -1) && (j-1 >= 0 && arr[i][j-1] == -1)){
                i++;
                arr[i][j] = fib[index];
                continue;
            }
            if (!(i+1 < n && arr[i+1][j] == -1) && (j-1 >= 0 && arr[i][j-1] == -1)){
                i++;
                arr[i][j] = fib[index];
                continue;
            }





            else if ((i+1 < n && arr[i+1][j] == -1)){
                i++;
            }else if ((j-1 >= 0 && arr[i][j-1] == -1) && (i-1>=0 && arr[i-1][j] == -1)){
                i--;
            }else if ((i-1>=0 && arr[i-1][j] == -1)){
                i--;
            }
            arr[i][j] = fib[index];
        }
        for (i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for (j=0; j<arr[0].length; j++){
                sb.append(arr[i][j]);
                if (j < arr[0].length - 1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static int[] fib(int n){
        int num = n * n;
        if (n == 0){
            return new int[0];
        }else if (n == 1){
            return new int[] {1};
        }
        int[] dp = new int[num];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<num; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp;
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
