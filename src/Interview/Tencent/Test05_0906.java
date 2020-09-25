package Interview.Tencent;



/**
 * @Author: xianz
 * @Date: 2020/9/6 20:02
 * @Title&Description:
 * 一行n和k，代表n个字符串和K个数
 * 下面n行，N个字符串
 *
 * 判断字符串出现次数。分别输出前K大和前K小
 *想法：
 * 先判断词频，之后是按照词频和字典序进行排序就行
 *
 *输入
4 2
1
2
3
4
 *输出
1 1
2 1
1 1
2 1
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;

public class Test05_0906 {

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
            solution(arr);
        }
    }

    public static void solution(int[] arr){
        for (int i=0; i<arr.length; i++){
            int cur = arr[i];
            if (cur == 1){
                System.out.println(1);
            }else {
                System.out.println(cur - 1);
            }
        }
    }


}
