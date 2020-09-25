//package Interview.BAIDU;
//
///**
// * @Author: xianz
// * @Date: 2020/9/3 20:08
// * @Title&Description:
//单组输入，输入数据有n+1行，其中n为像素矩阵的行数。
//
//
//
//输出描述
//每组输出数据包含n行，即模糊化之后的像素矩阵。
//
//对于输出数据的每一行，输出m个值，两两之间用空格隔开。
//20 27
//30 32
//如果计算所得的像素值为小数，需四舍五入取整。
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//
//import java.util.Scanner;
//
//public class Test02_0903 {
//
//    public static void main(String[] args) {
//
//    }
//
//    //第1行包含两个正整数n和m，用空格分隔，表示像素矩阵的行数和列数。n<=1000，m<=1000。
//    //
//    //接下来n行表示像素矩阵，每行包含m个取值范围为[0,255]的非负整数，两两之间用空格隔开。
//    public static void input(){
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] arr = new int[n][m];
//            for (int i=0; i<n; i++){
//                for (int j=0; j<m; j++){
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//            solution();
//        }
//    }
//
//    public static void solution(int[][] arr){
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr[0].length; j++){
//                int count = 0;
//                for (i)
//            }
//        }
//    }
//
//}
