package Interview.DAJIANG;

/**
 * @Author: xianz
 * @Date: 2020/8/16 20:53
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03_0816_3 {

    public static void main(String[] args) {
        test();
//        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            System.out.println(solution(s, k));
        }
    }

    public static void test(){
        String s = "71245323308";
        int k = 4;
        System.out.println(solution(s, k));
    }

    /**
     * 大概是需要保证剩下的第一位是最小的
     * @param s
     * @param k
     * @return
     */
    public static int solution(String s, int k){
        if (k == s.length()){
            return 0;
        }
        int delNum = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            while (!stack.isEmpty() && stack.peekFirst() > cur && delNum < k){
                stack.pollFirst();
                delNum++;
            }
            if (delNum > k){
                break;
            }
            if (cur != 0){
                stack.offerFirst(cur);
            }
        }
        while (delNum < k){
            stack.pollFirst();
            delNum++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        sb = sb.reverse();
        return Integer.valueOf(sb.toString());
    }
}
