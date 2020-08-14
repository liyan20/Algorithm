package Interview.BKZF;

/**
 * @Author: xianz
 * @Date: 2020/8/11 19:36
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int caseNum = sc.nextInt();
//            int[][] arr = new int[caseNum][2];
//            for (int i=0; i<caseNum; i++){
//                arr[i][0] = sc.nextInt();
//                arr[i][1] = sc.nextInt();
//            }
//            for (int i=0; i<caseNum; i++){
//                System.out.println(getNum(arr[i][0], arr[i][1]));
//            }
//        }
//    }

//    public static int getNum(int n, int m){
//        int[][] arr = new int[n][m];
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr[0].length; j++){
//                arr[i][j] = -1;
//            }
//        }
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr[0].length; j++){
//                if (i == 0 && j == 0){
//                    arr[i][j] = 1;
//                }else {
//                    int num1 = getArrNum(i-1,j,arr);
//                    int num2 = getArrNum(i,j-1,arr);
//                    int num3 = getArrNum(i+1,j,arr);
//                    int num4 = getArrNum(i,j+1,arr);
//                    int curMax1 = Math.max(num1, num2);
//                    int curMax2 = Math.max(num3, num4);
//                    int curMax = Math.max(curMax1, curMax2);
//                    if (curMax == 1){
//                        arr[i][j] = 2;
//                    }else {
//                        arr[i][j] = curMax - 1;
//                    }
//                }
//            }
//        }
//        int max = -1;
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr[0].length; j++){
//                max = Math.max(max, arr[i][j]);
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        System.out.println(getNum(3, 4));
    }

    public static int getNum(int n, int m){
        if (n == 1 && m == 1){
            return 1;
        }else if ((n == 1 && m != 1) || (n != 1 && m == 1)){
            int maxNmu = Math.max(n,m);
            for (int i=2; i<=maxNmu; i++){
                if (maxNmu % i == 0){
                    return i;
                }
            }
            return maxNmu;
        }else {
            int res = -1;
            for (int i=2; i<=Math.min(n, m); i++){
                if (n % i == 0 || m % i == 0){
                    res = i;
                    break;
                }
            }
            return res == -1 ? Math.min(n,m) : res;
        }
    }

//    public static int getArrNum(int i, int j, int[][] arr){
//        if (i >= 0 && i < arr.length && j >=0 && j < arr.length){
//            return arr[i][j];
//        }else {
//            return -1;
//        }
//    }


}
