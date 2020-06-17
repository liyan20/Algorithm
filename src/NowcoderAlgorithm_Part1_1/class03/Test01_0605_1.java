package NowcoderAlgorithm_Part1_1.class03;



/**
 * @Author: xianz
 * @Date: 2020/6/5 08:54
 * @Title&Description: 还是个排序的问题，这次我就用桶排序里面的基数排序吧
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.Scanner;
public class Test01_0605_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            Integer[] pIntegerArray = new Integer[num];
            for (int i=0; i<num; i++){
                pIntegerArray[i] = sc.nextInt();
            }
            int iSortFlag = sc.nextInt();
            sortIntegerArray(pIntegerArray, iSortFlag);
            for (int i=0; i<pIntegerArray.length; i++){
                System.out.print(pIntegerArray[i]);
                if (i != pIntegerArray.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag){
        if (pIntegerArray == null || pIntegerArray.length < 2){
            return;
        }
        radixSort(pIntegerArray, 0, pIntegerArray.length-1, getMaxBit(pIntegerArray));
        if (iSortFlag == 1){
            for (int i=0; i<pIntegerArray.length/2; i++){
                Integer temp = pIntegerArray[i];
                pIntegerArray[i] = pIntegerArray[pIntegerArray.length-1-i];
                pIntegerArray[pIntegerArray.length-1-i] = temp;
            }
        }
    }

    public static void radixSort(Integer[] arr, int L, int R, int digit){
        final int radix = 10;
        Integer[] bucket = new Integer[R - L + 1];
        for (int d=0; d<digit; d++){
            int[] count = new int[radix];
            for (int i=L; i<=R; i++){
                int j = getDigit(arr[i], d);
                count[j]++;
            }
            for (int i=1; i<radix; i++){
                count[i] += count[i-1];
            }
            for (int i=R; i>=L; i--){
                int j = getDigit(arr[i], d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            for (int i=L,j=0; i<=R&&j<bucket.length; i++,j++){
                arr[i] = bucket[j];
            }
        }
    }

    public static int getMaxBit(Integer[] arr){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            max = max < arr[i] ? arr[i] : max;
        }
        int digit = 0;
        while (max != 0){
            digit++;
            max /= 10;
        }
        return digit;
    }

    public static int getDigit(int num, int d){
        return (num / (int) (Math.pow(10, d))) % 10 ;
    }

}
