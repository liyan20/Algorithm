package Interview.PDD0802;

import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/8/2 20:24
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test04 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String[] arr0 = new String[6];
//            for (int i=0; i<6; i++){
//                arr0[i] = sc.nextLine();
//            }
//            System.out.println(getMaxNum(arr0));
//        }
//    }

    public static void main(String[] args) {
        String[] arr0 = new String[6];
        arr0[0] = "##****";
        arr0[1] = "##****";
        arr0[2] = "******";
        arr0[3] = "******";
        arr0[4] = "******";
        arr0[5] = "******";
        System.out.println(getMaxNum(arr0));

    }

    public static int getMaxNum(String[] arr0){
        int[][] arr = new int[6][6];
        int allNum = 0;
        for (int i=0; i<arr0.length; i++){
            String curLine = arr0[i];
            for (int j=0; j<6; j++){
                if (curLine.charAt(j) == '#'){
                    allNum++;
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = 2;
                }
            }
        }
        int[] isUsed = new int[6];
        return bfs(arr, 0, 0, isUsed, allNum);
    }

    public static int bfs(int[][] arr, int i, int j, int[] isUsed, int notVisitedNum){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length){
            return 0;
        }
//        if (arr[i][j] != 0){
//            return 0;
//        }
        if (notVisitedNum == 0){
            return 1;
        }
        int res = 0;
        for (int index = 0; index < isUsed.length; index++){
            if (isUsed[index] == 0){
                isUsed[index] = 1;
                arr[i][j] = 1;
                res = res + bfs(arr, i-1, j, isUsed, notVisitedNum-1)
                        + bfs(arr, i+1, j, isUsed, notVisitedNum-1)
                        + bfs(arr, i, j-1, isUsed, notVisitedNum-1)
                        + bfs(arr, i, j+1, isUsed, notVisitedNum-1);
                arr[i][j] = 0;
                isUsed[index] = 0;
            }
        }
        return res;
    }

}
