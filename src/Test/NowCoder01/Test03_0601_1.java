package Test.NowCoder01;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/6/1 17:53
 * @Title&Description: 操作序列
 * 每次放入一个数，逆序，然后再放入，再逆序
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03_0601_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int[] arr = new int[num];
            for(int i=0;i<num;i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            solution(arr,list);
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i));
                if(i < list.size()-1){
                    System.out.print(" ");
                }
            }
        }
    }
    public static void solution(int[] arr, List<Integer> list){
        for (int i=0;i<arr.length;i++){
            list.add(arr[i]);
            reverse(list);
        }
    }
    public static void reverse(List<Integer> list){
        for (int i=0;i<list.size()/2;i++){
            int temp = list.get(i);
            list.set(i, list.get(list.size()-1-i));
            list.set(list.size()-1-i, temp);
        }
    }
}
