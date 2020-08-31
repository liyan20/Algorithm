package Interview.VIPKID;

/**
 * @Author: xianz
 * @Date: 2020/8/28 19:31
 * @Title&Description:
 * 实现一个基本计算器
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 实现一个基本的计算器，计算输入的字符串表达式的结果，字符串表达式中包含+,-,*,/四种运算符号和大于0的整数，除法仅保留整数部分。
 * 输入描述
 * 四则混合运算的字符串表达式
 *
 * 输出描述
 * 表达式的整数运算结果
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0828 {

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

    public static void test(){
        String s = "3+8*2-6/4";
        solution(s);
    }

    public static void solution(String s){
        Deque<Integer> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length){
            char cur = ch[i];
            if (Character.isDigit(cur)){
                stack.offerFirst(cur - '0');
                i++;
            }else {
                int next = ch[i+1] - '0';
                if (cur == '+'){
                    stack.offerFirst(next);
                }else if (cur == '-'){
                    stack.offerFirst(next * (-1));
                }else if (cur == '*'){
                    int n = stack.pollFirst();
                    stack.offerFirst(n * next);
                }else if (cur == '/'){
                    int n = stack.pollFirst();
                    stack.offerFirst(n / next);
                }
                i += 2;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollFirst();
        }
        System.out.println(res);
    }
}
