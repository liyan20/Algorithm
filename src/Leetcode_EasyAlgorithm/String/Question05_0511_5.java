package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/11 17:53
 * @Title: 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @Description: 1.去掉不是字母的东西 2.作比较就行
 * @Analysis: 只考虑字母和数字，其他符号不考虑
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question05_0511_5 {
    public static void main(String[] args) {
        String s = "./'[-+";
        System.out.println(s);
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }else if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        if(sb.length()==0){
            return true;
        }
        boolean flag = true;
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
