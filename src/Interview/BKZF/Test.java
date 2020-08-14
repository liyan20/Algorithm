package Interview.BKZF;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/8/11 20:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(countNums(4, 9));
    }

    public static int countNums(int m0, int n0){
        int m = Math.min(m0, n0);
        int n = Math.max(m0, n0);
        boolean[] isPrimArr = new boolean[n + 1];
        Arrays.fill(isPrimArr, true);
        for (int i=2; i*i<=n; i++){
            if (isPrimArr[i]){
                for (int j=i*i; j<=n; j+=i){
                    isPrimArr[j] = false;
                }
            }
        }
        int primNum = 0;
        for (int i=m; i<=n; i+=2){
            if (isPrimArr[i]){
                primNum++;
            }
        }
        return primNum;
    }
}
