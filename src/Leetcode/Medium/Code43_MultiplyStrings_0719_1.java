package Leetcode.Medium;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @Author: xianz
 * @Date: 2020/7/19 14:27
 * @Title&Description: 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @Analysis:
 * 一个coding问题。首先是把乘法拆解成字符串相加，写一个方法。
 * 然后是把整体乘法拆分成s1或s2是几位数就是几个字符串相加这种。
 * 拆分的时候写一个一位数和另一个字符串相乘的方法。就行了。
 * @Summary:
 * @TimeConsuming:
 */
public class Code43_MultiplyStrings_0719_1 {
    public static void main(String[] args) {
        String s1 = "99";
        String s2 = "999";
        System.out.println(multiply(s1, s2));
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null){
            return null;
        }
        if ((num1.length() == 1 && num1.charAt(0) == '0')
                || (num2.length() == 1 && num2.charAt(0) == '0')){
            return "0";
        }
        String sum = "0";
        //让num2拆解来和num1的每一位相乘
        for (int i=num2.length()-1; i>=0; i--){
            //调用单个相乘的方法，得到单个的结果
            String str = singleMultiply(String.valueOf(num2.charAt(i)), num1);
            StringBuilder temp2 = new StringBuilder(str);
            //把每一位的0补齐
            for (int j=num2.length()-i-1; j>0; j--){
                temp2.append(0);
            }
            sum = stringAdd(sum, temp2.toString());
        }
        return sum;
    }

    //s1是单个数字，与整个s2字符串相乘
    public static String singleMultiply(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=s2.length()-1; i>=0; i--){
            int cur = Integer.valueOf(String.valueOf(s2.charAt(i)))
                    * Integer.valueOf(String.valueOf(s1.charAt(0))) + carry;
            sb.append(cur % 10);
            carry = cur / 10;
        }
        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String stringAdd(String s1, String s2){
        if (s1 == null || s2 == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1, j = s2.length() - 1;
        for (; i>=0 || j>=0; i--, j--){
            int x = i < 0 ? 0 : Integer.valueOf(String.valueOf(s1.charAt(i)));
            int y = j < 0 ? 0 : Integer.valueOf(String.valueOf(s2.charAt(j)));
            int cur = x + y + carry;
            sb.append(cur % 10);
            carry = cur / 10;
        }
        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
