package SortAlgorithm;

/**
 * @Author: xianz
 * @Date: 2020/8/14 09:58
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class QuickSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(arr, randomIndex, right);
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0]-1);
        quickSort(arr, p[1]+1, right);
    }

    public static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right + 1;
        int index = left;
        int p = arr[right];

        while (index < more){
            if (arr[index] < p){
                swap(arr, index++, ++less);
            }else if (arr[index] > p){
                swap(arr, index, --more);
            }else {
                index++;
            }
        }
        return new int[] {less+1, more-1};
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
