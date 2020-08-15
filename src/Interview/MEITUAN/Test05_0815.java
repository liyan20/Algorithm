package Interview.MEITUAN;

/**
 * @Author: xianz
 * @Date: 2020/8/15 17:57
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test05_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[m][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                System.out.println(1);
                for (int j=0; j<=n; j++){
                    if (j != n){
                        System.out.println(j);
                    }else {
                        System.out.println();
                    }

                }
            }
        }
    }
}
