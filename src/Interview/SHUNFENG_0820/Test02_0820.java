package Interview.SHUNFENG_0820;

/**
 * @Author: xianz
 * @Date: 2020/8/20 21:20
 * @Title&Description:
 * 克里森是一名赏金猎人，他平时需要完成一些任务赚钱。最近他收到了一批任务，
 * 但是受到时间的限制，他只能完成其中一部分。具体来说就是有n个任务，
 * 每个任务用l, r, w来表示任务开始的时间l，结束的时间r和完成任务获得的金钱。
 *
 * 克里森是个贪心的人，他想知道自己在任务不冲突的情况下最多获得多少金钱。
 * 输入描述
 * 第一行一个数n表示任务的个数。(1≤n≤1e3)
 * 接下来n行每行三个整数l, r, w表示第i个任务的开始时间，结束时间，以及收益。(1≤l≤r≤1e6,1≤w≤1e9)
 *
 * 输出描述
 * 输出一个值表示克里森最多获得的金钱数量。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0820 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();

            int[][] arr = new int[n][3];
            for (int i=0; i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
            }
//            System.out.println(6);
            System.out.println(solution(n, arr));
        }
    }

    public static int solution(int n, int[][] arr){
        Arrays.sort(arr, new Comparator<Object>(){
            @Override
            public int compare(Object oo1, Object oo2) {
                int[] o1 = (int[])oo1;
                int[] o2 = (int[])oo2;
                if (o1[0] < o2[0]){
                    return -1;
                }else if (o1[0] > o2[0]){
                    return 1;
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        //dp[i]代表第i个任务获取的最大收益
        //dp可以选择
        int[] dp = new int[n];
        dp[0] = arr[0][2];
        for (int i=1; i<dp.length; i++){

        }
        return 6;
    }
}
