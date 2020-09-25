package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/9/21 11:16
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code394_DecodeString_0921 {

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString(s));
    }

    //使用栈，数字一个栈，字母一个栈
    public static String decodeString(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> letterStack = new ArrayDeque<>();

        for(int i=0; i<s.length(); ){
            char cur = s.charAt(i);
            //如果是数字，入栈数字栈
            if(Character.isDigit(cur)){
                StringBuilder sb = new StringBuilder();
                while(Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                numStack.offerFirst(Integer.valueOf(sb.toString()));
            }
            cur = s.charAt(i);
            if(cur == '[' || Character.isLetter(cur)){
                //将括号入栈
                letterStack.offerFirst(cur + "");
                i++;
            }else if(cur == ']'){
                //当遇到右括号的适合，需要开始生成字符串了。但是生成的字符串要放回栈里面
                mergeLetterStack(letterStack);  //组合中间的字符成为字符串

                //根据数字，将其累加多次，最后入栈。因为要考虑前面还有数字和括号的情况
                //即要考虑嵌套的情况
                int num = numStack.pollFirst();
                String curStr = letterStack.pollFirst();
                StringBuilder sb = new StringBuilder();
                while(num > 0){
                    sb.append(curStr);
                    num--;
                }
                letterStack.offerFirst(sb.toString());
                i++;
            }
        }
        List<String> list = new ArrayList<>();
        while(!letterStack.isEmpty()){
            list.add(letterStack.pollFirst());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    //将字母栈里面的字母进行整合。注意要到了第一个出现的左括号就停止
    public static void mergeLetterStack(Deque<String> stack){
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty() && !stack.peekFirst().equals("[")){
            list.add(stack.pollFirst());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        stack.pollFirst();
        stack.offerFirst(sb.toString());
    }
}
