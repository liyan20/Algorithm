package Interview.QUNAER;

/**
 * @Author: xianz
 * @Date: 2020/9/23 19:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03_0923 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String s = sc.nextLine();
            System.out.println("HuangJiaTongHuaShun");
        }
    }

//    public static void solution(String s){
//        String[] arr = s.split(" ");
//
//        //统计一下花色
//        Map<Character, Integer> colorMap = new HashMap<>();
//        for (String curStr : arr){
//            char ch = curStr.charAt(0);
//            if (!colorMap.containsKey(ch)){
//                colorMap.put(ch, 1);
//            }else {
//                colorMap.put(ch, colorMap.get(ch));
//            }
//        }
//
//        //将数字进行统计
//        Map<Integer, Integer> numMap = new HashMap<>();
//        int[] numArr = new int[arr.length];
//        for (int i=0; i<arr.length; i++){
//            String curStr = arr[i];
//            char ch = curStr.charAt(1);
//            int cur = 0;
//            if (Character.isDigit(ch)){
//                cur = Integer.valueOf(curStr.substring(1));
//            }else {
//                if (ch == 'A'){
//                    cur = 1;
//                }else if (ch == 'J'){
//                    cur = 11;
//                }else if (ch == 'Q'){
//                    cur = 12;
//                }else if (ch == 'K'){
//                    cur = 13;
//                }
//            }
//            if (!numMap.containsKey(cur)){
//                numMap.put(cur, 1);
//            }else {
//                numMap.put(cur, numMap.get(ch));
//            }
//            numArr[i] = cur;
//        }
//
//        Arrays.sort(numArr);
//        //先看花色相关的
//        //同花，同花顺，皇家同花顺
//        if (colorMap.size() == 1){
//            if (isShunzi(numArr)){
//                if ()
//            }
//        }
//    }

    //判断是不是顺子
    public static boolean isShunzi(int[] arr){
        int[] gapArr = new int[arr.length-1];
        for (int i=1; i<arr.length; i++){
            gapArr[i] = arr[i] - arr[i-1];
        }
        boolean flag = true;
        for (int i=0; i<gapArr.length; i++){
            if (gapArr[i] != 1){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
