package Interview.AIQIYI;

/**
 * @Author: xianz
 * @Date: 2020/8/23 15:17
 * @Title&Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 输入描述
 * 一个字符串，仅包含括号'('，')'，'{'，'}'，'['，']'
 * 输出描述
 * 如果字符串验证有效，返回 True
 * 如果字符串验证无效，返回 False
 * 样例输入
 * ()
 * 样例输出
 * True
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test03_0823 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            solution(s);
        }
    }

    public static void solution(String s){
        if (s == null){
            System.out.println("True");
            return;
        }
        boolean flag = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '['){
                stack.offerFirst(cur);
            }
            if (cur == ')'){
                if (stack.size() > 0 && stack.peekFirst() == '('){
                    stack.pollFirst();
                }else {
                    flag = false;
                    break;
                }
            }else if (cur == '}'){
                if (stack.size() > 0 && stack.peekFirst() == '{'){
                    stack.pollFirst();
                }else {
                    flag = false;
                    break;
                }
            }else if (cur == ']'){
                if (stack.size() > 0 && stack.peekFirst() == '['){
                    stack.pollFirst();
                }else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

}
