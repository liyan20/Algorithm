package Leetcode.Medium;

import java.util.Arrays;

/**
 * @Author: xianz
 * @Date: 2020/7/17 16:21
 * @Title&Description: 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * @Analysis:
 * 看了题解：滑动窗口方法
 * 判断字母全排列：对字符数组进行排序即可
 * @Summary:
 * @TimeConsuming:
 */
public class Code567_PermutationInString_0717_1 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1 || s2.length() < s1.length()){
            return false;
        }
        for (int i=0; i<=s2.length()-s1.length(); i++){
            String subStr = s2.substring(i, i + s1.length());
            if (isSamePermutation(subStr, s1)){
                return true;
            }
        }
        return false;
    }

    public static boolean isSamePermutation(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        char[] chaList1 = s1.toCharArray();
        char[] chaList2 = s2.toCharArray();
        Arrays.sort(chaList1);
        Arrays.sort(chaList2);
        for (int i=0; i<chaList1.length; i++){
            if (chaList1[i] != chaList2[i]){
                return false;
            }
        }
        return true;
    }
}
