package Interview.KDXF;

import java.util.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/7/31 14:35
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02 {
    public static void main(String[] args) {
        int[] arr = {25,84,21,47,15,27,68,35,20};
        sort(arr, 0, arr.length-1);
        for (int i : arr){
            System.out.print(i + "-");
        }
    }

    public static void sort(int[] arr, int L, int R){
        if (L < R){
            int p = arr[R];
            int less = L - 1;
            int index = L;
            while (index < R){
                if (arr[index] <= p){
                    swap(arr, index++, ++less);
                }else {
                    index++;
                }
            }
            index = less + 1;
            swap(arr, index, R);

            sort(arr, L, index-1);
            sort(arr, index+1, R);
            for (int i : arr){
                System.out.print(i + "-");
            }
            System.out.println();
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
