package Test.nowcoder_month7;

import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/7/17 18:48
 * @Title&Description: 独立的牛牛
 * 每天一个水果+支付x元房租。当前有f个水果和d元钱，每个水果卖p元，问最多独立生活多少天
 * 输入的是x, f, d, p，输出最多多少天
 * 1 <= x, f, d, p <= 2 * 10 ^ 9
 * 3,5,100,10 -> 11
 * @Analysis:
 * 想的复杂了，非常简单的一个问题
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long x = sc.nextLong();
            long f = sc.nextLong();
            long d = sc.nextLong();
            long p = sc.nextLong();
            System.out.println(maximunDays2(x,f,d,p));
        }

    }

    public static long maximunDays2(long homePrice, long fruitNum, long money, long fruitPrice){
        if (homePrice <= 0 || fruitNum < 0 || money < 0 || fruitPrice <= 0){
            return 0;
        }
        if ((money - fruitNum * homePrice) < (fruitPrice + homePrice)){
            if (money < fruitNum * homePrice){
                return money / homePrice;
            }else {
                return fruitNum;
            }
        }else {
            return (money - fruitNum * homePrice) / (fruitPrice + homePrice) + fruitNum;
        }
    }

//    public static int maximunDays(int homePrice, int fruitNum, int money, int fruitPrice){
//        if (homePrice <= 0 || fruitNum < 0 || money < 0 || fruitPrice <= 0){
//            return 0;
//        }
//        return maximunDays(homePrice, fruitNum, money, fruitPrice);
//    }
//
//    //主递归函数
//    //返回是在当前的条件下，能过多少天。变量是curMoney当前钱数和curFruitNum当前水果数。
//    public static int process(int homePrice, int curFruitNum, int curMoney, int fruitPrice){
//        //base case。
//        // 没钱交房租了
//        if (curMoney < homePrice){
//            return 0;
//        }
//        //有钱交房租，但是没钱买水果并且水果吃完了
//        if (curFruitNum == 0 && (curMoney - homePrice < fruitPrice)){
//            return 0;
//        }
//        //递归体
//        //首先下一天必须是要交租金的。水果方面根据是否还有可以买可以不买。
//        int max = 0;
//        if (curFruitNum == 0){
//            //i是买的水果数量，保证买水果的钱不超过房租剩下的钱
//            for (int i=1; i*fruitPrice <= curMoney - homePrice; i++){
//                int res = process(homePrice, curFruitNum - 1 + i, curMoney - homePrice - i * fruitPrice, fruitPrice);
//                max = Math.max(max, res + 1);
//            }
//        }else {
//            for (int i=0; i*fruitPrice <= curMoney - homePrice; i++){
//                int res = process(homePrice, curFruitNum - 1 + i, curMoney - homePrice - i * fruitPrice, fruitPrice);
//                max = Math.max(max, res + 1);
//            }
//        }
//        return max;
//    }
}
