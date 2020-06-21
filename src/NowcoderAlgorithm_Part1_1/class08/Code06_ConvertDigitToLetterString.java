package NowcoderAlgorithm_Part1_1.class08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/21 18:52
 * @Title&Description: 把数字转成字符串
 * 1和A对应，2和B对应，这样是26个字母。要把数字字符串转成字母字符串，可以认为是一位数字也可以是两位数字
 * 比如111可以是AAA，也可以是KA，也可以是AK，这种。求最终有多少种转法，就是数量
 * @Analysis:
 * 如果递归是逐渐变大的，那么base case一般是在等于最大值的时候
 * 有几种情况：
 * 1.当前数字是0，这么就不行，走不下去的，因为转换是从1开始的，一旦开头是0，不管是单独的0还是加上下一位01，02这种都是不行的
 * 2.当前数字是1，可以选择这一位或者是和下一位放在一起比如单独的1或者下面的11，12这种
 * 3，当前数字是2，可以选择单独一位，或者下一位在0-6之间的时候，可以选择两位
 * 3.当前数字是3-9，只能选择单独这一位
 * 注：选择两位在一起的前提是下一位存在
 * @Summary:
 * @TimeConsuming:
 */
public class Code06_ConvertDigitToLetterString {
    public static void main(String[] args) {
        String str = "11134";
        System.out.println(number(str));
    }

    public static List<String> number(String str){
        Map<Integer, Character> map = new HashMap<>();
        for (int i=1; i<=26; i++){
            map.put(i, (char)('a' + i - 1));
        }
        if (str == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        process(str, 0, "", list, map);
        return list;
    }

    //这个str是给的字符串，i是代表着从i开始之后的是什么情况。i之前的已经处理好了
    public static void process(String str, int i, String path, List<String> list, Map<Integer, Character> map){
        //base case，i到头了，返回数量，数量就是1，是指的这条路径是1
        if (i == str.length()){
            list.add(path);
            return;
        }
        char temp = str.charAt(i);
        if (temp == '0'){
            return;
        }
        if (temp == '1'){
            //这个递归代表，+1之后的process过程有几种情况
            process(str, i + 1, path + map.get(Integer.valueOf(String.valueOf(temp))), list, map);
            if (i + 1 < str.length()){
                process(str, i + 2, path + map.get(Integer.valueOf(str.substring(i, i + 2))), list, map);
            }
            //返回。注意，不是void的递归函数，递归体是一定要return的，因为递归函数本身就是应该是返回的东西
            return;
        }
        if (temp == '2'){
            process(str, i + 1, path + map.get(Integer.valueOf(String.valueOf(temp))), list, map);
            if (i + 1 < str.length() && (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '6')){
                process(str, i + 2, path + map.get(Integer.valueOf(str.substring(i, i + 2))), list, map);
            }
            return;
        }
        //剩下的就是当前是3-9的情况
        process(str, i + 1, path + map.get(Integer.valueOf(String.valueOf(temp))), list, map);
        return;
    }
}
