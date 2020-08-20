package NowcoderAlgorithm_HighLevel2020.DP;

import java.util.Scanner;

/**
 * @Author: xianz
 * @Date: 2020/8/16 07:37
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_LongestCommonSubstring_0816_1 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            System.out.println(longestCommonSubstring(s1, s2));
//        }
//    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(longestCommonSubstring(s1, s2));
    }

    /**
     * dp[i][j]代表的是s1以i结尾，s2以j结尾，的时候的最长公共子串。
     * 这个子串，在边界处，如果两个数不相等，那就是0，相等，那就是1.
     * 这个和最长公共子序列不一样，这个是要求子串必须以i和j结尾。所以，任如果不相等，那么一定是0，
     * 如果相等，那么就要看i-1和j-1的最长公共子串是多少，就给加上去就行了
     *
     * 即每个位置只与其左上角有关，并且最终的输出是整个dp表的最大值。
     * @param s1
     * @param s2
     * @return 这个是牛客的程序员代码面试指南里面的题目，要求是打印这个最长公共子串
     */
    public static String longestCommonSubstring(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1){
            return "-1";
        }
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        int maxIndex = Integer.MIN_VALUE;
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 : 0;
                }else {
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 + dp[i-1][j-1] : 0;
                }
                if (dp[i][j] > max){
                    max = dp[i][j];
                    maxIndex = i;
                }
            }
        }
        if (max == 0){
            return "-1";
        }else {
            return s1.substring(maxIndex - max + 1, maxIndex + 1);
        }
    }
}
