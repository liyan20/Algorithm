package Collections.serialize;

import java.math.BigInteger;

/**
 * @Author: xianz
 * @Date: 2020/8/31 19:40
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0831 {

    public static void main(String[] args) {
        System.out.println(isValid(10));
        while (true){

        }
    }

    public static long nextNarcissisticNumber (int n) {
        long num = n;
        while (true){
            if (isValid(num)){
                return num;
            }
            num++;
        }
    }

    public static boolean isValid(long n){
        long m = n;
        long sum = 0;
        long length = String.valueOf(n).length();
        while (n > 0){
            sum += (long)Math.pow(n % 10, length);
            n /= 10;
        }
        return sum == m;
    }

}
