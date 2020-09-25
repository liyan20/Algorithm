package Interview.Tencent;



/**
 * @Author: xianz
 * @Date: 2020/9/6 20:02
 * @Title&Description:

听歌。每个歌曲有时间。

感觉是贪心，优先听最短的那个，然后最后一分钟听最长的那个就行。

 *输入
5
1 2 3 4 5
14
 *输出
15
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test04_0906 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            solution(arr, m);
        }
    }

    /**
     *
     * @param arr 歌曲的数组
     * @param m 允许的时间
     */
    public static void solution(int[] arr, int m){
        //如果直接不超过m的话
        if (getSum(arr) <= m){
            System.out.println(m);
            return;
        }

        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        for (i=0; i<arr.length; i++){
            if (sum >= m){
                break;
            }
            sum += arr[i];
        }

        i = 0;
        while (sum >= m){
            sum -= arr[i];
            i++;
        }
        sum += arr[arr.length-1];
        System.out.println(sum);
    }

    public static int getSum(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }
}
