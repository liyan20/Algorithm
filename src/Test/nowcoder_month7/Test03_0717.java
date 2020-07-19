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
public class Test03_0717 {
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
    }

    public static String isHealthy(int[] arr){
        int days = arr[0];
        int num1 = arr[1];
        int num2 = arr[2];
        int num3 = arr[3];
        if (process(days, num1, num2, num3) > 0){
            return "Yes";
        }
        return "No";
    }

    //递归函数。参数：当前的日期
    public static int process(int index, int num1, int num2, int num3){
        if (num1 < 0 || num2 < 0 || num3 < 0){
            return 0;
        }
        if (num1 + 2 * num2 + 3 * num3 < index * 6){
            return 0;
        }
        if (index == 0){
            return 1;
        }
        int res = process(index-1, num1-6, num2, num3) +
                process(index-1, num1, num2-3, num3) +
                process(index-1, num1, num2, num3-2) +
                process(index-1, num1-4, num2-2, num3) +
                process(index-1, num1-2, num2-2, num3) +
                process(index-1, num1-3, num2, num3-1) +
                process(index-1, num1-1, num2-1, num3-1);
        return res;
    }
}
