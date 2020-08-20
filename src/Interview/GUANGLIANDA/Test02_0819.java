package Interview.GUANGLIANDA;

/**
 * @Author: xianz
 * @Date: 2020/8/19 19:21
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02_0819 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long[] arr = new long[4];
            for (int i=0; i<4; i++){
                arr[i] = sc.nextLong();
            }
            System.out.println(solution(arr));
        }
    }

    public static long solution(long[] arr){
        Arrays.sort(arr);
        long sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]){
            return sum;
        }
        long cost1_1 = getCost(arr, 0, 1);
        long cost1_2 = getCost(arr, 2, 3);
        long cost1 = validate(cost1_1, cost1_2);

        long cost2_1 = getCost(arr, 0, 2);
        long cost2_2 = getCost(arr, 1, 3);
        long cost2 = validate(cost2_1, cost2_2);

        long cost3_1 = getCost(arr, 1, 2);
        long cost3_2 = getCost(arr, 0, 3);
        long cost3 = validate(cost3_1, cost3_2);

        cost1 = cost1 == -1 ? Long.MAX_VALUE : cost1;
        cost2 = cost2 == -1 ? Long.MAX_VALUE : cost2;
        cost3 = cost3 == -1 ? Long.MAX_VALUE : cost3;
        long costAll = Long.MAX_VALUE;
        costAll = Math.min(cost1, cost2);
        costAll = Math.min(costAll, cost3);
        if (costAll == Long.MAX_VALUE){
            return -1;
        }

        return sum - costAll;
    }

    public static long validate(long l1, long l2){
        if (l1 == -1 || l2 == -1){
            return -1;
        }
        return l1 + l2;
    }

    public static long getCost(long[] arr, int i, int j){
        long min = arr[i];
        long max = arr[j];
        if ((max - min) % 3 == 0){
            return (max - min) / 3;
        }else {
            return -1;
        }
    }
}
