package Interview.QIHU360;

/**
 * @Author: xianz
 * @Date: 2020/8/22 19:53
 * @Title&Description: 给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），
 * 现在要对排列进行M次操作，每次操作为以下两种中一种：
 *
 * ①将排列的第1个数移到末尾；
 *
 * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
 *
 * 求经过这M次操作后得到的排列。

 * 输入描述
 * 第一行包含两个整数N和M，2≤N，M≤105。
 * 第二行包含M个空格隔开的整数t1到tM，1≤ti≤2。若ti=1，则表示第i次操作为操作①；若ti=2，则表示第i次操作为操作②。
 * 输出描述
 * 输出N个空格隔开的整数，即经过M次操作后得到的排列。
 *
 * 样例输入
 * 4 3
 * 1 2 1
 * 样例输出
 * 2 1 4 3
 *
 * 提示
 * 排列变化过程为：{1 2 3 4}->{2 3 4 1}->{3 2 1 4}->{2 1 4 3}。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0822 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i=0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            solution(n, arr);
        }
    }

    public static void solution(int n, int[] arr){
        int[] res = new int[n];
        for (int i=0; i<res.length; i++){
            res[i] = i + 1;
        }
        for (int i=0; i<arr.length; i++){
            process(arr[i], res);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; i++){
            sb.append(res[i]);
            if (i != res.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void process(int num, int[] arr){
        if (num == 1){
            int temp = arr[0];
            for (int i=0; i<arr.length-1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
        }else if (num == 2){
            for (int i=0; i<arr.length-1; i+=2){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}
