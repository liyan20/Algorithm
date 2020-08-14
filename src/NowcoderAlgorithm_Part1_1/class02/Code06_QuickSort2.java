package NowcoderAlgorithm_Part1_1.class02;

import java.util.Comparator;

/**
 * @Author: xianz
 * @Date: 2020/5/30 22:30
 * @Title&Description: 快速排序3.0版
 * @Analysis: 之前的是选最后一个数当成p，这里面是选择随机一个数当成p，同时是把这个数和最后一个交换
 * 这样的话，好坏情况的时间复杂度都会出现，根据数学计算，最终时间复杂度会收敛到O(nlogn)
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code06_QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {10,5,14,8,16,3,20};
        quickSort(arr, 0, arr.length-1);
        for (int temp : arr){
            System.out.print(temp + "-");
        }
    }
    public static void quickSort(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
//        swap(arr, L+(int)(Math.random()*(R-L+1)), R);
        int[] p = partition(arr, L, R);
        quickSort(arr, L, p[0]-1);
        quickSort(arr, p[1]+1, R);
    }
    //这个partition还是对最后一个数作为p进行处理的，处理的是0到倒数第二个数
    public static int[] partition(int[] arr, int L, int R){
        int p = arr[R];
//        int p = 10;
        int less = L - 1;
        int more = R + 1;    //所以这里面more是R而不是R+1，因为是处理不包括R的数组范围
        int index = L;
        while (index < more){
            if (arr[index] < p){
                swap(arr, index++, ++less);
            }else if(arr[index] > p){
                swap(arr, index, --more);
            }else {
                index++;
            }
        }
//        swap(arr, more, R);
        return new int[] {less+1, more-1};    //这里面因为more的位置和最后一个数交换了，所以就不需要是more-1了
        //这边返回的是等于p的起点和终点。上面交换的那个可以交换也可以直接在全部上面partition，讲道理我觉得差不多
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }







}
