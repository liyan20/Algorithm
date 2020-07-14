package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/7/14 08:34
 * @Title&Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Analysis:
 * 本题使用滑动窗口算法
 * 窗口的L每次往右移动一个，代表子串的起点。R每次向右移动，直到出现重复单词就停止。
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_LongestSubstringWithoutRepeatingCharacters_0714_1 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int R = 0, res = 0;
        //R代表字符串里面最右边不重复的字符的index，因为当前的i不重复，i右移之后自然不重复，减少了每次R从0开始计算的消耗
        //并且每次L往右动，R也往右动，是为滑动窗口
        for (int i=0; i<s.length(); i++){
            //L向右移动的时候，去掉set里面对应的字符
            //i->i+1，L到了i+1的位置上，删除i位置的字符
            if (i != 0){
                set.remove(s.charAt(i - 1));
            }
            //R向右遍历，直到重复的时候停止
            //这里的R代表当前的位置。在while循环之前R是没有判断的。每次判断R是否符合条件，符合的话加进去。
            //之后R++。所以结束之后R的位置是窗口的下一位。
            while (R < s.length() && !set.contains(s.charAt(R))){
                set.add(s.charAt(R));
                R++;
            }
            res = Math.max(res, R - i);
        }
        return res;
    }
}
