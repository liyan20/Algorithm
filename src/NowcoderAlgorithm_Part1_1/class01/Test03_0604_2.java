package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/6/4 08:52
 * @Title&Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * @Analysis: 自底而上的相加法
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Test03_0604_2 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(Fibonacci(n));

    }

    public static int Fibonacci(int n){
        if (n == 0 || n == 1){
            return n;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i=2; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[arr.length-1];
    }
}
