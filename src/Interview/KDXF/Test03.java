package Interview.KDXF;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/31 14:52
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] arr1 = new int[4];
            int[] arr2 = new int[4];
            for (int i=0; i<arr1.length; i++){
                arr1[i] = sc.nextInt();
            }
            for (int i=0; i<arr2.length; i++){
                arr2[i] = sc.nextInt();
            }
            System.out.println(isOverlap(arr1, arr2));
        }
    }

//    public static void main(String[] args) {
//        int[] arr1 = {0,0,4,2};
//        int[] arr2 = {0,1,5,3};
//        System.out.println(isOverlap(arr1, arr2));
//    }

    public static int isOverlap(int[] arr1, int[] arr2){
        Map<Integer, Integer> map1 = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        geneSet(set1, arr1);
        geneSet(set2, arr2);
        for (String str : set1){
            if (set2.contains(str)){
                return 1;
            }
        }
        return 0;
    }

    public static void geneSet(Set<String> set, int[] arr){
        int iStart = Math.min(arr[0], arr[2]);
        int iEnd = Math.max(arr[0], arr[2]);
        int jStart = Math.min(arr[1], arr[3]);
        int jEnd = Math.max(arr[1], arr[3]);
        //这里面加上等于号就行
        for (int i=iStart; i<=iEnd; i++){
            for (int j=jStart; j<=jEnd; j++){
                set.add(i + "*" + j);
            }
        }
    }
}
