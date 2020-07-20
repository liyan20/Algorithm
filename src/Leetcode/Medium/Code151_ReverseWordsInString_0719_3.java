package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/19 21:23
 * @Title&Description: 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @Analysis:
 * 想法是用空格分割字符串，再拼起来。
 * @Summary:
 * @TimeConsuming:
 */
public class Code151_ReverseWordsInString_0719_3 {
    public static void main(String[] args) {
        String s = "hello     world!    ";
        String[] list = s.split("s+");
        System.out.println(new Code151_ReverseWordsInString_0719_3().reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1){
            return "";
        }
        String[] strArr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=strArr.length-1; i>=0; i--){
            sb.append(strArr[i]);
            if (i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
