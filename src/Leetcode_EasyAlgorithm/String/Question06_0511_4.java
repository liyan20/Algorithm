package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/11 16:59
 * @Title: 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
 * 则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming: 47min 很多种情况要考虑，这个写的太复杂了，感觉不行
 */
public class Question06_0511_4 {
    public static void main(String[] args) {
        String str = " 0";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder(str);
        StringBuilder out = new StringBuilder();
        while(sb.length()>0){
            if(sb.charAt(0) == ' '){
                sb.deleteCharAt(0);
            }else{
                break;
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        if(sb.charAt(0)!='+' && sb.charAt(0)!='-' && !Character.isDigit(sb.charAt(0))){
            return 0;
        }else{
            int index = 1;
            for(;index<sb.length();index++){
                if(!Character.isDigit(sb.charAt(index))){
                    break;
                }
            }
            out.append(sb.substring(0, index));
        }
        if(out.charAt(0) == '+' || out.charAt(0)=='-'){
            while(out.length()>1){
                if(out.charAt(1) == '0'){
                    out.deleteCharAt(1);
                }else{
                    break;
                }
            }
            if(out.length() == 1){
                return 0;
            }
        }else {
            while(out.length()>0){
                if(out.charAt(0) == '0'){
                    out.deleteCharAt(0);
                }else{
                    break;
                }
            }
            if(out.length()==0){
                return 0;
            }
        }
        if(out.length() == 1 && !Character.isDigit(out.charAt(0))){
            return 0;
        }
        if(Character.isDigit(out.charAt(0)) && out.length()>10){
            return Integer.MAX_VALUE;
        }
        if((out.charAt(0)=='+' || out.charAt(0)=='-') && out.length()>11){
            return out.charAt(0)=='+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(Character.isDigit(out.charAt(0))){
            long temp = Long.valueOf(out.toString());
            if(temp>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int) temp;
            }
        }
        if(out.charAt(0)=='+'){
            long temp = Long.valueOf(out.substring(1, out.length()));
            if(temp>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int) temp;
            }
        }else if(out.charAt(0)=='-'){
            long temp = -Long.valueOf(out.substring(1, out.length()));
            if(temp<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return (int) temp;
            }
        }
        return 0;
    }
}
