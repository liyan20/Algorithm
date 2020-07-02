package Coding_Interviews;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/1 20:31
 * @Title&Description: 字符流中第一个不重复的字符
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Analysis:
 * 目前的想法是，使用一个hashmap和linkedhashset，第一个保存所有的，第二个是
 * @Summary:
 * @TimeConsuming:
 */
public class Code54_FirstUniqChar_0701_2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.remove(Integer.valueOf(1));
        System.out.println(list);
    }

    private Map<Character, Integer> map = new HashMap<>();
    private List<Character> list = new ArrayList<>();

    public void Insert(char ch) {
        //放入hashmap中，统计次数，如果第一次出现放入list，如果出现过，删除list里面对应的
        if (!map.containsKey(ch)){
            map.put(ch, 1);
            list.add(ch);
        }else {
            map.put(ch, map.get(ch) + 1);
            list.remove(Character.valueOf(ch));
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return list.size() > 0 ? list.get(0) : '#';
    }
}
