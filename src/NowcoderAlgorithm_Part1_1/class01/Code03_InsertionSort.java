package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/5/27 09:51
 * @Title&Description: 插入排序
 * @Analysis: 首先判断0-0是否有序，有序，再判断0-1是否有序，如果arr[1]<arr[0]，交换两个数
 * 之后判断0-2是否有序，针对arr[2]，向前比较，如果小于，就交换，如果遇到第一个大于的，就停止。因为前面的是已经是有序的
 * 所以插入排序其实就是在第i轮，针对arr[i]，向前判断是否有序，小于的话就交换，再向前比较，直到第一个不小于停止
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code03_InsertionSort {
    public static void main(String[] args) {
//        int[] arr = {2,4,756,34,34,876,453,4,432};
        int[] arr = {4,2,4};
        insertionSort(arr);
        for(int temp:arr){
            System.out.println(temp);
        }
    }

    public static void insertionSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
//        for(int e=0;e<arr.length;e++){
//            for (int i=e;i>0;i--){
//                if(arr[i]<arr[i-1]){
//                    swap(arr, i, i-1);
//                }else {
//                    break;
//                }
//            }
//        }

        for (int i=1;i<arr.length;i++){      //0到i上面有序
            //第二个循环把判断条件放在了循环控制里面，很巧妙。我之前的方法是针对每一个判断，如果不小于就break
            for (int j=i;j>0 && arr[j]<arr[j-1];j--){
                swap(arr, j, j-1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
