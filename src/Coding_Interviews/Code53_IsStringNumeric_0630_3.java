package Coding_Interviews;

/**
 * @Author: xianz
 * @Date: 2020/6/30 15:23
 * @Title&Description: 表示数值的字符串
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @Analysis:
 * 应该是一道coding问题，但是考虑的东西很多
 * 貌似数字本身是不是合法是无所谓的，比如005
 * 特殊字符有e,E,.,+,-
 * 1.E或e：之后必须有东西，不能在最后；之后不能有小数点，不能在开头
 * 2.+-号：必须在开头或者e/E的后面
 * 3..：小数点只能出现一次，不能在开头
 * 4.不能出现其他字符
 *
 * 注意：要用if else if，不能用多重if
 *
 * @Summary:
 * @TimeConsuming:
 */
public class Code53_IsStringNumeric_0630_3 {
    public static void main(String[] args) {
        String s = " ";
        char[] str = s.toCharArray();
        System.out.println(str);
        char cur = str[0];
        System.out.println(cur < '0' || cur > '9');
        System.out.println(isNumeric(str));
    }

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length < 1){
            return false;
        }
        int j = 0;
        boolean hasE = false;
        boolean hasPoint = false;
        for (int i=0; i<str.length; i++){
            char cur = str[i];
            //判断首位
            if (i == 0){
                if (cur == 'e' || cur == 'E' || cur == '.'){
                    return false;
                }
            }
            if (cur == 'e' || cur == 'E'){
                if (hasE){
                    return false;
                }
                if (i == str.length - 1){
                    return false;   //E之后没有东西
                }
                //E之后如果有小数点，不行
                for (j = i + 1; j < str.length; j++){
                    if (str[j] == '.'){
                        return false;
                    }
                }
                hasE = true;  //不能有两个E
            }else if (cur == '+' || cur == '-'){
                //不在开头，也不在E的后面，不行
                if (i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else if (cur == '.'){
                if (hasPoint){
                    return false;
                }
                hasPoint = true;
            }else if (cur < '0' || cur > '9'){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric_LC(String s) {
        if (s == null || s.length() < 1){
            return false;
        }
        char[] str = s.toCharArray();
        int j = 0;
        boolean hasE = false;
        boolean hasPoint = false;
        for (int i=0; i<str.length; i++){
            char cur = str[i];
            //判断首位
            if (i == 0){
                if (cur == 'e' || cur == 'E' || cur == '.'){
                    return false;
                }
            }
            if (cur == 'e' || cur == 'E'){
                if (hasE){
                    return false;
                }
                if (i == str.length - 1){
                    return false;   //E之后没有东西
                }
                //E之后如果有小数点，不行
                for (j = i + 1; j < str.length; j++){
                    if (str[j] == '.'){
                        return false;
                    }
                }
                hasE = true;  //不能有两个E
            }else if (cur == '+' || cur == '-'){
                //不在开头，也不在E的后面，不行
                if (i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else if (cur == '.'){
                if (hasPoint){
                    return false;
                }
                hasPoint = true;
            }else if (cur < '0' || cur > '9'){
                return false;
            }
        }
        return true;
    }



}
