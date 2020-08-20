package Interview.DAJIANG;

/**
 * @Author: xianz
 * @Date: 2020/8/16 19:21
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0816 {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int dayNum = sc.nextInt();
            int[] gain = new int[N];
            int[] time = new int[N];
            for (int i=0; i<N; i++){
                gain[i] = sc.nextInt();
                time[i] = sc.nextInt();
            }
            System.out.println(solution(gain, time, dayNum));
        }
    }

    public static void test(){
        int dayNum = 2;
        int[] gain = {10,20};
        int[] time = {1,2};
        System.out.println(solution(gain, time, dayNum));
    }

    public static int solution(int[] gain, int[] time, int dayNum){
        return process(dayNum, 0, gain, time);
    }

    /**
     * 选择gain[index ...]之后所有范围找
     * @param rest
     * @param index
     * @param gain
     * @param time
     * @return
     */
    public static int process(int rest, int index, int[] gain, int[] time){
        if (rest < 0){
            return -1;
        }
        if (index == gain.length){
            return 0;
        }
        //两种选择，拿这个Index的东西和不拿的情况
        int next1 = process(rest - time[index], index + 1, gain, time);
        int next2 = process(rest, index + 1, gain, time);
        next1 = next1 == -1 ? 0 : next1 + gain[index];
        next2 = next2 == -1 ? 0 : next2;
        return Math.max(next1, next2);
    }
}
