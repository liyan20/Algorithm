package Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: xianz
 * @Date: 2020/5/26 17:46
 * @Title&Description: 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @Analysis: 代码还没有写完，这个只是找到有效的个数，但是并不是连续的，以后再写吧。05.26 18.05
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code32_LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));

    }
    public static int longestValidParentheses(String s) {
        if(s.length()==0 || s.length()==1){
            return 0;
        }
        Deque<Character> stack = new LinkedList<>();
        int num = 0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.offerFirst(cur);
            }else if(cur == ')'){
                if(stack.pollFirst() != null){
                    num++;
                }
            }
        }
        return num;
    }
}
