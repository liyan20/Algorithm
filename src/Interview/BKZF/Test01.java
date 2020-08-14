package Interview.BKZF;

/**
 * @Author: xianz
 * @Date: 2020/8/11 19:11
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String str = sc.nextLine();
            System.out.println(getCyStr(str));
        }
    }

//    public static void main(String[] args) {
//        String str = "fergeargeabg";
//        System.out.println(getCyStr(str));
//    }

    public static int getCyStr(String str){
        int left = 0;
        int right = str.length() - 1;
        int sum = 0;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                sum++;
            }
            left++;
            right--;
        }
        return sum;
    }
}
