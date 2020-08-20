package NowcoderAlgorithm_HighLevel2020.DP;

/**
 * @Author: xianz
 * @Date: 2020/8/14 07:54
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code03_LongestCommonSubsequence_0814_1 {

    /**
     * dp[i][j]代表在str1[0...i]和str2[0...j]两个子前缀串的最长公共子序列是多长。
     * 如果是i==0或者j==0，那么只要有一个是相等的，后面都是1了。
     * 如果i!=0并且j!=0的时候，就需要判断：
     * 首先，如果str1的第i个字符和str2的第j个字符相同，那么就是dp[i-1][j-1] + 1，也好理解，因为这个位置相同肯定是属于
     * 最长公共子序列里面的一部分，就需要把前面的不包含这两个的最长公共子序列加上1就完事了。
     * 第二，如果两个字符不相等，那么要判断左边和右边的dp，dp[i-1][j]和dp[i][j-1]，
     * 因为可能这个子串是从左边向右延申的，也可能是从上面往下面延申的，选个最大的。
     *
     * 这个理解还有点问题，现在明白一点了，就是如果两个字符不相等，那么肯定最长公共子序列不会更新了，因为你不相等，
     * 那不肯定是没有这个i和j什么事的吗，那么就是其实是三种情况。一个是和i,j-1的关系，就是最长公共子序列是以
     * str1[i]结尾的，不以str2[j]结尾，那就是判断dp[i][j-1]的值了，或者是不以str1[i]结尾的，而是以str2[j]结尾，
     * 那就是判断dp[i-1][j]的值了。其实还有一个，那就是最长公共子序列不以str1[i]结尾的，也不以str2[j]结尾，
     * 那么就是dp[i-1][j-1]的了，三种情况，选个最大值就完事了。
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() < 1 || text2.length() < 1){
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        int max = 0;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 && j == 0){  //边界情况
                    dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                }else if(i == 0 && j != 0){  //边界情况
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }else if(i != 0 && j == 0){  //边界情况
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{  //最普通的情况
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 这个是在获取到最长公共子序列长度之后，如何获得这个最长公共子序列是什么。
     * 我们需要从dp表里面获取到，因为我们的答案是dp表的最后一个，所以倒着来。
     * 先是看dp[i][j]的值，看其和上面的和左边的是否相等，相等的话说明其是来自于上面和左边的，当然
     * 如果i和j位置相等的话，也可能是来自于i-1,j-1的值+1的情况。如果这三种情况都有可能，那说明可能就不止一种
     * 最长公共子序列，那么随便选一个就行。如果上面和左边不和i-j位置一样，那么这时候肯定是i位置与j位置相等，
     * 这时候就是倒序的最长公共子序列必定有i位置或者j位置的数，然后跳转到左上角i-1和j-1，接着判断就行了。
     * 直到越界。
     *
     * @param dp
     * @return
     */
    public static String getSubSequence(int[][] dp){
        return "";
    }

    /**
     * 获取所有的最长公共子序列。
     * 既然既可以往左走，也可以往上走，那么就深度优先遍历就行了。
     * @param dp
     * @return
     */
    public static String getAllSubSequence(int[][] dp){
        return "";
    }
}
