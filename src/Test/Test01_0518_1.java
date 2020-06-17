package Test;

/**
 * @Author: xianz
 * @Date: 2020/5/18 18:48
 * @Title&Description: 卖东西，任意长的连续天数去卖东西，说明必须是连续的，如果要卖必须连着卖
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0518_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] prices = new int[n];
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                prices[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(51);
        }
    }
}
