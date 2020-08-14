package Interview.PDD0802;

/**
 * @Author: xianz
 * @Date: 2020/8/2 19:06
 * @Title&Description: 96%不知道问题在哪，算了
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i=0; i<N; i++){
                nums[i] = sc.nextInt();
            }
            paradox(K, nums);
        }
    }

//    public static void main(String[] args) {
//        int K = 10;
//        int[] nums = {6,3,3,3};
//        paradox(K, nums);
//    }

    public static void paradox(int K, int[] nums){
        if (K == 0){
            System.out.println("paradox");
            return;
        }
        if (K < 0){
            System.out.println(K + "" + 0);
        }
        int distance = K;
        boolean isParadox = false;
        int backNum = 0;
        for (int i=0; i<nums.length; i++){
            int curNum = nums[i];
            if (curNum == distance){
                isParadox = true;
                break;
            }else if (curNum < distance){
                distance = distance - curNum;
            }else {
                distance = curNum - distance;
                backNum++;
            }
        }
        if (isParadox){
            System.out.println("paradox");
        }else {
            System.out.println(distance + " " + backNum);
        }
    }
}
