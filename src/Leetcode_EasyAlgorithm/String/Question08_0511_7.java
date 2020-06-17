package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/11 19:00
 * @Title: 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question08_0511_7 {
    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            System.out.println(countAndSay(i));
        }
    }
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String out = "1";
        {
            for(int i=1;i<n;i++){
                out = countIter(out);
            }
            return out;
        }

    }
    public static String countIter(String str){
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        int num = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == temp){
                num++;
            }else {
                sb.append(num);
                sb.append(temp);
                temp = str.charAt(i);
                num = 1;
            }
        }
        sb.append(num);
        sb.append(temp);
        return sb.toString();
    }
}
