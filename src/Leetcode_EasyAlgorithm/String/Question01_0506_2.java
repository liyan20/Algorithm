package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/6 15:08
 * @Title: 反转字符串
 * @Description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @Analysis: 输入：["h","e","l","l","o"]，输出：["o","l","l","e","h"]
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question01_0506_2 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
     }

    public static void reverseString(char[] s) {
        if(s.length>1){
            for(int i=0;i<s.length/2;i++){
                char temp = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = temp;
            }
        }
    }
}
