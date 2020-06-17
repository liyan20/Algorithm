package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/5/27 09:27
 * @Title&Description: 冒泡排序算法
 * @Analysis: 对0-n-1数据进行顺序的两两比较，0和1，1和2，2和3这种。如果大，就交换两个。这样两两比较，
 * 一轮过后，最大的就会到最后一个位置n-1上。然后接着遍历0-n-2的数据，第二大的到n-2位置上
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,756,34,34,876,453,4,432};
        bubbleSort(arr);
        for(int temp:arr){
            System.out.println(temp);
        }
    }

    public static void bubbleSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for (int j=arr.length-1;j>0;j--){
            for (int i=0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
