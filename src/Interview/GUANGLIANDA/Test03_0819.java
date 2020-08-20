package Interview.GUANGLIANDA;

/**
 * @Author: xianz
 * @Date: 2020/8/19 18:50
 * @Title&Description: 你购买了一个机器人，它现在剩下C单位电量，你现在想让它做一些动作愉悦自己。
 * 它可以做n种动作，每种动作最多做一次，因为你觉得让机器人重复做一种动作是无聊的。
 * 每种动作都有一个固定电量花费ci单位电量，以及这个动作的愉悦度wi。
 * 请在你电量范围内让它做出让你最愉悦的动作。即做的动作的总电量消耗不能超过C，并使愉悦度之和最大。
 * （我们将情景简化，电量在开始动作前就要扣除，若电量不足则无法开始作，不存在动作进行到一半的状态）
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03_0819 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            double c = (double) sc.nextInt();
            double[] cost = new double[n];
            int[] gain = new int[n];
            for (int i=0; i<n; i++){
                cost[i] = sc.nextDouble();
                gain[i] = sc.nextInt();
            }
            System.out.println(solution2(c, cost, gain));
        }
    }

    /**
     * 有点像全排列。每个动作可以做也可以不做。最终要使得愉悦度最大，电量可以不用完
     * @param c
     * @param cost
     * @param gain
     * @return
     */
    public static int solution(double c, double[] cost, int[] gain){
        return process(0, c, cost, gain);
    }

    /**
     * 貌似主要的变量只有一个就是index了。每次判断是否要这个动作还是不要这个动作即可
     * @param index
     * @param rest
     * @param cost
     * @param gain
     * @return
     */
    public static int process(int index, double rest, double[] cost, int[] gain){
        if (rest < 0){
            return -1;
        }
        if (index == cost.length){
            return 0;
        }
        //可以要或者不要
        int next1 = process(index+1, rest, cost, gain);
        int next2 = process(index+1, rest-cost[index], cost, gain) + gain[index];
        next1 = next1 == -1 ? 0 : next1;
        next2 = next2 == -1 ? 0 : next2;
        return Math.max(next1, next2);
    }

    /**
     * dp的参数i,j代表在i的位置，j的剩余的情况下的最大值
     * @param c
     * @param cost
     * @param gain
     * @return
     */
    public static int solution2(double c, double[] cost, int[] gain){
        if (c <= 0 && cost.length < 1){
            return 0;
        }
        double[][] dp = new double[cost.length+1][(int)c+1];
        for (int i=cost.length-1; i>=0; i--){
            for (int j=0; j<dp[0].length; j++){
                double next1 = dp[i+1][j];
                double next2 = j-cost[i] < 0 ? 0 : dp[i+1][(int)(j-cost[i])] + gain[i];
                dp[i][j] = Math.max(next1, next2);
            }
        }
        return (int)dp[0][dp[0].length-1];
    }
}
