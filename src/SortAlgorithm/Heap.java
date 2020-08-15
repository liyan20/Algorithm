package SortAlgorithm;

/**
 * @Author: xianz
 * @Date: 2020/8/14 10:31
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Heap {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=3; i<=99; i+=2){
            sum += i * (i + 2);
        }
        System.out.println(sum);
    }
}
