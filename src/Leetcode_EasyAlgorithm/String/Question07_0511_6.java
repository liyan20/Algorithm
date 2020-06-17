package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/11 18:20
 * @Title: 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question07_0511_6 {
    public static void main(String[] args) {
        String haystack = "abb", needle = "abaaa";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0 ){
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        int index = 0;
        for(;index<haystack.length()-needle.length()+1;index++){
            if(haystack.charAt(index) == needle.charAt(0)){
                if(haystack.substring(index, index+needle.length()).equals(needle)){
                    break;
                }
            }
        }
        if(index == haystack.length()-needle.length()+1){
            return -1;
        }else {
            return index;
        }
    }
}
