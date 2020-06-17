package Leetcode_EasyAlgorithm.String;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/5/11 08:31
 * @Title: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * @Description: 目前的想法是使用LinkedHashMap，按照顺序放进去，有的话就+1，
 * 这样找到最前面的和字符串个数相同的那几个字母就行了
 * 修正：想的简单了，如果单词内部有重复的就不好办了
 * @Analysis: 新想法：1.先取得字符串最小值，然后把第一个字符串的0到min字串，遍历剩下的，
 * 如果遇到没有包含的，删除sb里面那个位置剩下的。最终保存的就是公共的8
 * @ThinkingSteps: 对于空数组，空字符串直接返回""。
 * @TimeConsuming:
 */
public class Question09_0511_2 {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("12345");
//        System.out.println(sb.delete(2, 4).toString());
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            if(str.length()==0){
                flag = false;
                break;
            }
        }
        if(!flag){
            return "";
        }
        int minLen = strs[0].length();       //得到最短数组
        for(String str:strs){
            if(str.length()<minLen){
                minLen = str.length();
            }
        }
        sb.append(strs[0].substring(0, minLen));
        for(int i=1;i<strs.length;i++){
            for(int j=0;j<sb.length();j++){
                if(strs[i].charAt(j) != sb.toString().charAt(j)){
                    sb.delete(j, sb.length());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
