package Interview.BLBL;

/**
 * @Author: xianz
 * @Date: 2020/8/13 20:14
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0813 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.nextLine();
//            System.out.println(solution(str));
//
//        }
//    }

    public static void main(String[] args) {
        String str = "2 1 2 2 3";
        System.out.println(solution(str));
    }

    public static int solution(String str){
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i=0; i<strArr.length; i++){
            arr[i] = Integer.valueOf(strArr[i]);
        }
        int[] weights = new int[arr.length];
        Arrays.fill(weights, 1);
        //从左往右遍历。满足右边比左边大，右边的就多。
        for (int i=1; i<arr.length; i++){
            if (arr[i] > arr[i-1]){
                weights[i]++;
            }
        }
        //处理左边比右边大的情况
        for (int i=arr.length-1; i>0; i--){
            if (arr[i] < arr[i-1] && weights[i] >= weights[i-1]){
                weights[i]++;
            }
        }
        int max = 0;
        for (int i=0; i<arr.length; i++){
            max += weights[i];
        }
        return max;
    }
}
