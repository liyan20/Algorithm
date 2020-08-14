package Interview.BKZF;

/**
 * @Author: xianz
 * @Date: 2020/8/11 19:14
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            countNums(m, n);
//        }
//    }

    public static void main(String[] args) {
        countNums(2,5235);
    }

    public static void countNums(int m0, int n0){
        int m = Math.min(m0, n0);
        int n = Math.max(m0, n0);
        boolean[] isPrimArr = new boolean[n + 1];
        Arrays.fill(isPrimArr, true);
        for (int i=2; i<=n; i++){
            if (isPrimArr[i]){
                for (int j=2; i*j<=n; j++){
                    isPrimArr[i*j] = false;
                }
            }
        }
        int primNum = 0;
        for (int i=m; i<=n; i++){
            if (isPrimArr[i]){
                primNum++;
            }
        }
        String res = primNum + " " + (n - m + 1);
        if (primNum == 0){
            System.out.println(res);
            return;
        }else {
            System.out.println(getEquation(res));
        }
    }

    public static String getEquation(String str){
        String[] arr = str.split(" ");
        int m = Integer.valueOf(arr[0]);
        int n = Integer.valueOf(arr[1]);
        while (true){
            int num = 0;
            for (int i=2; i<=m; i++){
                if (m % i == 0 && n % i == 0){
                    m /= i;
                    n /= i;
                    num = i;
                    break;
                }
            }
            if (num == 0){
                break;
            }
        }
        return m + " " + n;
    }
}
