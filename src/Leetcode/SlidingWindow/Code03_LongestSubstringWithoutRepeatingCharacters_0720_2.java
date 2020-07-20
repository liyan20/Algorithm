package Leetcode.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/7/20 18:57
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
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_LongestSubstringWithoutRepeatingCharacters_0720_2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        int max = 0, R = 0;
        Set<Character> set = new HashSet<>();
        //注意，循环里面每次对滑动窗口的处理是针对每一次移动的情况的
        //R代表字符串里面最右边不重复的字符的index，因为当前的i不重复，i右移之后自然不重复，
        //减少了每次R从0开始计算的消耗。并且每次L往右动，R也往右动，是为滑动窗口
        for (int i=0; i<s.length(); i++){
            //滑动窗口L的处理。每到一个位置，删除前一位的
            //我们思考这个遍历i的时候应该是思考这个第i位是该怎么做，而不是第一位是怎么做。
            if (i != 0){
                set.remove(s.charAt(i - 1));
            }
            //滑动窗口R的处理。
            while (R < s.length() && !set.contains(s.charAt(R))){
                set.add(s.charAt(R++));
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
