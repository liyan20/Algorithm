package Interview.PDD2;

/**
 * @Author: xianz
 * @Date: 2020/9/1 19:16
 * @Title&Description:
 * 遍历0，遇到一个0就给变成1，之后是BFS看有多少个1.
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0901 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i=0; i<arr.length; i++){
                for (int j=0; j<arr[0].length; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            solution(arr);
        }
    }

    public static void solution(int[][] arr){
        int max = 0;
        int[][] nums = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                nums[i][j] = arr[i][j];
            }
        }
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<nums[0].length; j++){
                max = Math.max(getSum2(nums, i, j), max);
            }
        }

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j] == 0){
                    int[][] isVisited = new int[arr.length][arr[0].length];
                    arr[i][j] = 1;
                    int sum = getSum(arr, i, j, isVisited);
                    if (!islandSum(arr)){
                        sum--;
                    }
                    max = Math.max(max, sum);
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }

    public static int getSum2(int[][] arr, int i, int j){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length || arr[i][j] == 0){
            return 0;
        }
        arr[i][j] = 0;
        int res = 1;
        res += getSum2(arr, i-1, j) + getSum2(arr, i+1, j) +
                getSum2(arr, i, j-1) + getSum2(arr, i, j+1);
        return res;
    }

    public static int getSum(int[][] arr, int i, int j, int[][] isVisited){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length || isVisited[i][j] == 1 || arr[i][j] == 0){
            return 0;
        }
        isVisited[i][j] = 1;
        int res = 1;
        res += getSum(arr, i-1, j, isVisited) + getSum(arr, i+1, j, isVisited) +
                getSum(arr, i, j-1, isVisited) + getSum(arr, i, j+1, isVisited);
        return res;
    }

    public static boolean islandSum(int[][] nums) {
        int[][] arr = new int[nums.length][nums[0].length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = nums[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1){
                    sum++;
                    if (sum > 1){
                        return true;
                    }
                    process(arr, i, j);
                }
            }
        }
        return false;
    }

    public static void process(int[][] arr, int i, int j){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length || arr[i][j] == 0){
            return;
        }
        arr[i][j] = 0;
        process(arr, i+1, j);
        process(arr, i-1, j);
        process(arr, i, j+1);
        process(arr, i, j-1);
    }

}
