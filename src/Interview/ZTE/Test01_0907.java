package Interview.ZTE;



/**
 * @Author: xianz
 * @Date: 2020/9/7 10:28
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 * 稍微明白了。
 * M行代表m个科目，每行有n个代表n个人。
 * 某一行就是这个科目，这n个人考了多少分。
 */

import java.util.Scanner;
public class Test01_0907 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            solution(arr);
        }
    }

    public static void solution(int[][] arr){
        //计算一下平均分
        double[] aveArr = new double[arr.length];
        for (int i=0; i<arr.length; i++){
            double sum = 0;
            for (int j=0; j<arr[0].length; j++){
                sum += arr[i][j];
            }
            aveArr[i] = sum / arr[0].length;
        }

        int sum = 0;
        //以学生为基准
        for (int i=0; i<arr[0].length; i++){
            for (int j=0; j<arr.length; j++){
                int curScore = arr[j][i];  //当前科目的分数
                if (curScore > aveArr[j]){
                    sum++;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
