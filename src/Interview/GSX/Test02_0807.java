package Interview.GSX;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/8/7 20:33
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0807 {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s){
        if (s == null || s.length() < 1){
            return s;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArr = s.toCharArray();
        for (int i=0; i<charArr.length; i++){
            char cur = charArr[i];
            if (cur == '('){
                stack.offerFirst(i);
            }else if (cur == ')'){
                reverse(charArr, stack.pollFirst()+1, i-1);  //对括号内的字符进行反转
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charArr.length; i++){
            char cur = charArr[i];
            if (cur != '(' && cur != ')'){
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }

    public static void reverse(char[] arr, int left, int right){
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

