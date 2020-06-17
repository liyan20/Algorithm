package NowcoderAlgorithm_Part1_1.class03;

/**
 * @Author: xianz
 * @Date: 2020/5/31 14:10
 * @Title&Description: 计数排序
 * 比如一个数组，里面的数的范围是0-200之间。我们创建一个长为200的新数组，这个就是桶。我们对给的数组做一个词频统计
 * 再把桶里面的数从小到大取出来。
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_CountSort {
    public static void main(String[] args) {
        int[] arr = {5,7,3,45,67,87,3,54,23,75,126,34,178,90,100,201};
        countSort(arr);
        for(int temp : arr){
            System.out.print(temp + ",");
        }
    }

    public static void countSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //计算数值的最大值
        int max = Integer.MIN_VALUE;
        for(int temp : arr){
            max = Math.max(max, temp);
        }
        //建立长度为max的桶bucket，把原数组进行词频计数
        int[] bucket = new int[max + 1];
        for(int i=0; i<arr.length; i++){
            bucket[arr[i]]++;
        }
        //把数组里面按照顺序不为零的取出来
        int i = 0;
        for(int j=0; j<bucket.length; j++){
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
    }

}
