package Interview.Tencent;



/**
 * @Author: xianz
 * @Date: 2020/9/6 20:02
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test01_0906 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int len1 = sc.nextInt();
            int[] arr1 = new int[len1];
            for (int i=0; i<arr1.length; i++){
                arr1[i] = sc.nextInt();
            }
            int len2 = sc.nextInt();
            int[] arr2 = new int[len2];
            for (int i=0; i<arr2.length; i++){
                arr2[i] = sc.nextInt();
            }
            solution(arr1, arr2);
        }
    }

    public static void solution(int[] arr1, int[] arr2){
        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new ArrayList<>();
        while (p1 < arr1.length && p2 < arr2.length ){
            if (arr1[p1] < arr2[p2]){
                p2++;
            }else if (arr1[p1] > arr2[p2]){
                p1++;
            }else if (arr1[p1] == arr2[p2]){
                list.add(arr1[p1]);
                p1++;
                p2++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            if (i != list.size()-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

}
