package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/5/27 09:07
 * @Title&Description: 选择排序算法
 * @Analysis: 遍历数组的0 - n-1，找到最小的放在第0位，然后遍历1 - n-1，找到最小的放在第1位，一直这样下去就可以了
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {2,4,756,34,34,876,453,4,4,2,432};
        selectionSort(arr);
        for(int temp:arr){
            System.out.println(temp);
        }
    }

    public static void selectionSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
