package Interview.KDXF;

/**
 * @Author: xianz
 * @Date: 2020/7/31 13:57
 * @Title&Description: 第一题是零钱找零的。
 * 有
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int[] nums = new int[5];
//            for (int i=0; i<nums.length; i++){
//                nums[i] = sc.nextInt();
//            }
//            int money = sc.nextInt();
//            System.out.println(minTickets(nums, money));
//        }
//    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,5};
        int money = 57;
        System.out.println(minTickets(nums, money));
    }

    public static int minTickets(int[] nums, int money){
        for (int i=0; i<nums.length; i++){
            if (nums[i] < 0){
                return -1;
            }
        }
        if (money < 0){
            return -1;
        }
        if (money == 0){
            return 0;
        }
        int[] cache = new int[money+1];
        Arrays.fill(cache, -2);
        int[] prices = new int[5];
        prices[0] = 1;
        prices[1] = 5;
        prices[2] = 10;
        prices[3] = 50;
        prices[4] = 100;
        int res = process(nums, prices, money, cache);
//        return res;
        return (res == Integer.MAX_VALUE  || res < 0) ? -1 : res;
    }
    public static int process(int[] nums, int[] prices, int rest, int[] cache){
        for (int i=0; i<nums.length; i++){
            if (nums[i] < 0){
                return -1;
            }
        }
        if (rest < 0){
            return -1;
        }
        if (rest == 0){
            cache[rest] = 0;
            return 0;
        }
        if (cache[rest] != -2){
            return cache[rest];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0){
                nums[i]--;
                int res = process(nums, prices, rest - prices[i], cache) + 1;
                if (res > 0){
                    min = Math.min(min, res);
                }
                nums[i]++;
            }
        }
        cache[rest] = min;
        return min;
    }
}
