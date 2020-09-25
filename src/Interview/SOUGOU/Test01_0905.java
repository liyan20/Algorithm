package Interview.SOUGOU;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/9/5 18:37
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0905 {

    public static void main(String[] args) {
        System.out.println(numberofprize(9, 3, 3));
    }

    public static int max;

    public static int numberofprize (int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        a = arr[0];
        b = arr[1];
        c = arr[2];
        Arrays.sort(arr);
        if (a == 0 && b == 0){
            return c / 5;
        }
        if (a == 0){
            return (b+c) / 4;
        }

        //各种情况处理完了说明没有是0的
        int sum = a;
        return process(0, arr);
    }


    public static int process(int index, int[] arr){
        int sum = 0;
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        b -= a;
        c -= a;
        if (b == 0){
            return sum + c / 5;
        }
        if ((b + c) / 4 <= b){
            sum += (b+c) / 4;
            return sum;
        }
        sum += b;
        c = c - b * 3;
        return sum + c / 5;
    }
}
