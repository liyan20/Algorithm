package Interview.KDXF;

import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/7/31 14:43
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(strToInt(str));
        }
    }

//    public static void main(String[] args) {
//        String str = "a123";
//    }

    public static int strToInt(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            if (Character.isDigit(cur) || cur == '+' || cur == '-'){
                sb.append(cur);
            }
        }
        String s = sb.toString();
        return Integer.valueOf(s);
    }
}
