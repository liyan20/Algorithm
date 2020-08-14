package Leetcode.Medium;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/13 17:30
 * @Title&Description: 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @Analysis:
 * 回文串的子问题：
 * 如果子串是回文的，那么前后各加一个相同的字符也是回文的
 * base case只有一个或者两个一样的数的时候是回文的
 *
 * 写了半天，感觉这边不能用递归，必须直接使用自下而上的动态规划
 * 因为递归的话没办法填完整张表的感觉啊
 * @Summary:
 * 需要自己设置一张表，在纸上画一下。
 * @TimeConsuming:
 */
public class Code05_LongestPalindromicSubstring_0713_1 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null){
            return null;
        }
        if (s.length() == 0){
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化。对角线是true，其他的为false。默认是false
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i != j){
                    dp[i][j] = false;
                }
            }
        }
        //因为是每个地方和左下角的结果相关，所以应该是按照对角线的顺序来填表
        //这时候的循环最外层变量需要是每次i和j相差的数，从0开始递增
        //里面循环是i和j，i和j相差是level，因为每次的对角线都需要i从0开始进行。
        int begin = 0, maxLength = 0;
        for (int level=0; level < s.length(); level++){
            for (int i = 0, j = i + level; i<dp.length && j<dp[0].length; i++, j++){
                //一个数的情况，是回文
                if (i == j){
                    dp[i][j] = true;
                }
                //两个数的情况，如果相同就是true
                if ((j - i == 1) && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                //超过两位字符，就和子串有关系
                if (j - i  > 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
                //如果是回文，记录一下长度和起始的，保存下来
                if (dp[i][j]){
                    if (j - i + 1 > maxLength){
                        maxLength = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}
