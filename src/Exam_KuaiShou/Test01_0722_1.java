package Exam_KuaiShou;

/**
 * @Author: xianz
 * @Date: 2020/7/22 20:43
 * @Title&Description: 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0722_1 {
    public int countPrimes(int n) {
        if (n <= 1){
            return 0;
        }
        int res = 1;
        for (int i=3; i<n; i++){
            if (i % 2 == 0){
                continue;
            }
            if (isPrime(i)){
               res++;
            }
        }
        return res;
    }

    public static boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        for (int i=2; i<=Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
