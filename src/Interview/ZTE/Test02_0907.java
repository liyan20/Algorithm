package Interview.ZTE;



/**
 * @Author: xianz
 * @Date: 2020/9/7 10:28
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:

 */

import java.util.*;

public class Test02_0907 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int t = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i=0; i<t; i++){
                int len = sc.nextInt();
                int[] arr = new int[len];
                for (int j=0; j<len; j++){
                    arr[j] = sc.nextInt();
                }
                list.add(arr);
            }
            solution(list);
        }
    }

    public static void solution(List<int[]> list){
        for (int i=0; i<list.size(); i++){
            int[] cur = list.get(i);
            System.out.println(process(cur));
        }
    }

    //求一个最长公共子序列就完事了
    public static int process(int[] arr){
        //获得去重后的数组
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        int[] arrSort = new int[set.size()];
        int index = 0;
        for (int temp : set){
            arrSort[index] = temp;
            index++;
        }

        //获得正序排序数组和逆序排序数组
        Arrays.sort(arrSort);
        int[] arrSortRev = new int[arrSort.length];
        for (int i=0; i<arrSort.length; i++){
            arrSortRev[i] = arrSort[arrSort.length - 1 - i];
        }

        //获取两个的最大值
        int max1 = getLCS(arr, arrSort);
        int max2 = getLCS(arr, arrSortRev);
        int max = Math.max(max1, max2);
        return arr.length - max;
    }

    //计算两个数组的最长公共子序列
    public static int getLCS(int[] arr, int[] arrSort){
        int[][] dp = new int[arr.length][arr.length];
        int max = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arrSort.length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = arr[i] == arrSort[j] ? 1 : 0;
                }else if (i == 0 && j != 0){
                    if (arr[i] == arrSort[j]){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                }else if (i != 0 && j == 0){
                    if (arr[i] == arrSort[j]){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    if (arr[i] == arrSort[j]){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
