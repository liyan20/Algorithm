package Interview.NetE;

/**
 * @Author: xianz
 * @Date: 2020/8/8 15:09
 * @Title&Description: E, EM, M, MH, H分别代表简单，简单或者中等，中等，中等或者难，难题
 * 要求每次必须简单中等难各有一道，求问最多多少道比赛
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] arr = new int[5];
            for (int i=0; i<5; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getMaxNum(arr));
            System.out.println(4);
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {2,2,1,2,2};
//        System.out.println(getMaxNum(arr));
//    }

    public static int getMaxNum(int[] arr){
        int e = arr[0];
        int em = arr[1];
        int m = arr[2];
        int mh = arr[3];
        int h = arr[4];
        int[] cache = new int[5];
        return process(arr, e, em, m, mh, h, cache);
    }

    //让process返回这样取的最大值
    public static int process(int[] arr, int e, int em, int m, int mh, int h, int[] cache){
        if ((e == 0 && em == 0) || (em == 0 && m == 0 && mh == 0) || (mh == 0 && h == 0)){
            return 0;
        }
        if (e < 0 || em < 0 ||  m < 0 || mh < 0 || h < 0){
            return -1;
        }
        int[] allArr = new int[12];
        allArr[0] = process(arr, e-1, em-1, m, mh-1, h, cache);
        allArr[1] = process(arr, e-1, em-1, m, mh, h-1, cache);
        allArr[2] = process(arr, e-1, em, m-1, mh-1, h, cache);
        allArr[3] = process(arr, e-1, em, m-1, mh, h-1, cache);
        allArr[4] = process(arr, e-1, em, m, mh-2, h, cache);
        allArr[5] = process(arr, e-1, em, m, mh-1, h-1, cache);
        allArr[6] = process(arr, e, em-2, m, mh-1, h, cache);
        allArr[7] = process(arr, e, em-2, m, mh, h-1, cache);
        allArr[8] = process(arr, e, em-1, m-1, mh-1, h, cache);
        allArr[9] = process(arr, e, em-1, m-1, mh, h-1, cache);
        allArr[10]= process(arr, e, em-1, m, mh-2, h, cache);
        allArr[11] = process(arr, e, em-1, m, mh-1, h-1, cache);
        Arrays.sort(allArr);
        int max = allArr[allArr.length - 1];
        return max != -1 ? max + 1 : 0;
    }
}
