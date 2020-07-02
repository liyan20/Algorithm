package Leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/7/1 20:46
 * @Title&Description: 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode50_FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null){
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch, 1);
                list.add(ch);
            }else {
                map.put(ch, map.get(ch) + 1);
                list.remove(Character.valueOf(ch));
            }
        }
        return list.size() > 0 ? list.get(0) : ' ';
    }
}
