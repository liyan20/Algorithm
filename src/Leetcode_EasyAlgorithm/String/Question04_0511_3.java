package Leetcode_EasyAlgorithm.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/5/11 11:25
 * @Title: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @Description: 1.先看两个字符串长度，如果不一样，就返回false。2.用hashmap，放当前字符的个数
 * 2.如果都是空字符串，也是true
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming: 9min
 */
public class Question04_0511_3 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(!map1.containsKey(temp)){
                map1.put(temp, 1);
            }else {
                map1.put(temp, map1.get(temp)+1);
            }
        }
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char temp = t.charAt(i);
            if(!map2.containsKey(temp)){
                map2.put(temp, 1);
            }else {
                map2.put(temp, map2.get(temp)+1);
            }
        }
        if(map1.equals(map2)){
            return true;
        }else{
            return false;
        }
    }
}
