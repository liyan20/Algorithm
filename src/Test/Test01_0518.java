package Test;

/**
 * @Author: xianz
 * @Date: 2020/5/18 19:09
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0518 {
    public static void main(String[] args) {
        System.out.println(rightStr("picture", 4));


    }
    public static String rightStr(String str, int n){
        StringBuilder sb = new StringBuilder();
        n = n % str.length();
        sb.append(str.substring(str.length()-n, str.length()));
        sb.append(str.substring(0, str.length()-n));
        return sb.toString();
    }
}
