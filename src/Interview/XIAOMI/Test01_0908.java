package Interview.XIAOMI;

/**
 * @Author: xianz
 * @Date: 2020/9/8 18:25
 * @Title&Description: 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。
 * 检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。
 * 符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
 *
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 *
 *
 *
 * 输入描述
 * 需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
 *
 * 输出描述
 * 每个密码的检查结果，每个结果需要换行输出
 * @Analysis:
 * 样例输入
 * 123 12345678 123abcABC!!!
 * 样例输出
 * 1
 * 2
 * 0
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0908 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            solution(s);
        }
    }

    public static void solution(String s){
        String[] arr = s.split(" ");
        for (int i=0; i<arr.length; i++){
            System.out.println(isValid(arr[i]));
        }
    }

    public static int isValid(String s){
        if (s.length() < 8 || s.length() > 120){
            return 1;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (Character.isDigit(cur)){
                map.put("digit", 1);
            }else if (Character.isUpperCase(cur)){
                map.put("up", 1);
            }else if (Character.isLowerCase(cur)){
                map.put("low", 1);
            }else {
                map.put("signal", 1);
            }
        }
        return map.size() == 4 ? 0 : 2;
    }

}
