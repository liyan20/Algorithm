package Coding_Interviews;

/**
 * @Author: xianz
 * @Date: 2020/7/3 08:42
 * @Title&Description: 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code49_StrToInt {
    public static void main(String[] args) {
        String str = "-2147483647";
        System.out.println(StrToInt(str));
    }

    public static int StrToInt(String str) {
        if (str == null || str.length() < 1){
            return 0;
        }
        int flag = 0;
        //先判断各种非法情况
        for (int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            if (i == 0 && cur == '+'){
                flag = 1;
            }else if (i == 0 && cur == '-'){
                flag = -1;
            }
            if (i != 0 && (cur < '0' || cur > '9')){
                return 0;
            }
        }
        int start = flag != 0 ? 1 : 0;
        long res = 0;
        for (int i=start; i<str.length(); i++){
            char cur = str.charAt(i);
            res = res * 10 + Integer.valueOf(String.valueOf(cur));
        }
        res = flag != 0 ? flag * res : res;
        return (int) res;
    }
}
