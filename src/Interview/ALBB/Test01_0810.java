package Interview.ALBB;

/**
 * @Author: xianz
 * @Date: 2020/8/10 19:03
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0810 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(distance(arr));

        }
    }

//    public static void main(String[] args) {
//        int[] arr = {0,1,4,6};
//        System.out.println(distance(arr));
//    }

//    public static int distance(int[] arr){
//        Arrays.sort(arr);
//        int min = Integer.MAX_VALUE;
//        int L = arr.length / 2 - 1;
//        int R = arr.length % 2 == 0 ? L + 1 : L + 2;
//        for (int i=0; i<arr[arr.length-1]; i++){  //i代表水塔位置
//            int dis = 0;
//            for (int j=0; j<arr.length; j++){  //j代表第几个树
//                dis += Math.abs(i - arr[j]);
//            }
//            min = Math.min(min, dis);
//        }
//        return min;
//    }

    public static int distance(int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int L = arr.length / 2 - 1;
        int R = arr.length % 2 == 0 ? L + 1 : L + 2;
        for (int i=arr[L]; i<=arr[R]; i++){  //i代表水塔位置
            int dis = 0;
            for (int j=0; j<arr.length; j++){  //j代表第几个树
                dis += Math.abs(i - arr[j]);
            }
            min = Math.min(min, dis);
        }
        return min;
    }

    public static int distance2(int[] arr){
        Arrays.sort(arr);
        int mid = 0;
        int dis = 0;
        if (arr.length % 2 == 1){
            mid = arr[arr.length / 2];
        }else {
            int L = arr.length / 2 - 1;
            int R = L + 1;
            mid = arr[L] + ((arr[R] - arr[L]) / 2);
        }
        for (int j=0; j<arr.length; j++){  //j代表第几个树
            dis += Math.abs(mid - arr[j]);
        }
        return dis;
    }

    public static int distance3(int[] arr){
        Arrays.sort(arr);
        int mid = 0;
        int dis = 0;
        if (arr.length % 2 == 1){
            mid = arr[arr.length / 2];
        }else {
            int L = arr.length / 2 - 1;
            int R = L + 1;
            mid = arr[L] + ((arr[R] - arr[L]) / 2);
        }
        for (int j=0; j<arr.length; j++){  //j代表第几个树
            dis += Math.abs(mid - arr[j]);
        }
        return dis;
    }
}
