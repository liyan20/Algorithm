package Test.nowcoder_month7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/7/17 20:00
 * @Title&Description:
 * 吃雪糕。每天要吃雪糕，最多不能吃超过6份。ABC三种规格，分布是1，2，3份雪糕
 * 给高温天数和ABC三种规格的数量。
 * 懂了，是一天必须要吃够六份才行，要不然不够。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int nums = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i=0; i<nums; i++){
                int[] arr = new int[4];
                for (int j=0; j<4; j++){
                    arr[j] = sc.nextInt();
                }
                list.add(arr);
            }
            for (int i=0; i<list.size(); i++){
                System.out.println(isHealthy(list.get(i)));
            }
        }
//        System.out.println(isHealthy(new int[] {8,21,370,264}));
    }

    public static String isHealthy(int[] arr){
        int days = arr[0];
        int num1 = arr[1];
        int num2 = arr[2];
        int num3 = arr[3];
        int[][][][] cache = new int[days+1][num1+1][num2+1][num3+1];
        for (int i=0; i<=days; i++){
            for (int j=0; j<=num1; j++){
                for (int k=0; k<=num2; k++){
                    for (int y=0; y<=num3; y++){
                        cache[i][j][k][y] = -1;
                    }
                }
            }
        }
        int res = process(days, num1, num2, num3, cache);
        if (res > 0){
            return "Yes";
        }
        return "No";
    }

    //递归函数。参数：当前的日期
    public static int process(int index, int num1, int num2, int num3, int[][][][] cache){
        if (num1 < 0 || num2 < 0 || num3 < 0 || index < 0){
            return 0;
        }
        if (num1 + 2 * num2 + 3 * num3 < index * 6){
            cache[index][num1][num2][num3] = 0;
            return 0;
        }
        if (index == 0){
            cache[index][num1][num2][num3] = 1;
            return 1;
        }
        if (cache[index][num1][num2][num3] != -1){
            return cache[index][num1][num2][num3];
        }
        int res = process(index-1, num1-6, num2, num3, cache) +
                process(index-1, num1, num2-3, num3, cache) +
                process(index-1, num1, num2, num3-2, cache) +
                process(index-1, num1-4, num2-2, num3, cache) +
                process(index-1, num1-2, num2-2, num3, cache) +
                process(index-1, num1-3, num2, num3-1, cache) +
                process(index-1, num1-1, num2-1, num3-1, cache);
        cache[index][num1][num2][num3] = res;
        return res;
    }
}
