package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/7/1 21:02
 * @Title&Description: 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode05_ReplaceSpace_0701_4 {
    public String replaceSpace(String s) {
        if (s == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (cur == ' '){
                sb.append("%20");
            }else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
