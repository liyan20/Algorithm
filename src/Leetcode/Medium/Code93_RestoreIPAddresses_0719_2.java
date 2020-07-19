package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/19 20:32
 * @Title&Description: 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @Analysis: 回溯算法。就是搜索就完事了
 * @Summary:
 * @TimeConsuming:
 */
public class Code93_RestoreIPAddresses_0719_2 {
    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12){
            return res;
        }
        process(0, new ArrayList<>(), s, res);
        return res;
    }

    //递归函数。参数：当前递归函数搜索到哪个位置index，这个index是还没有考虑的；
    // 目前已经搜索到的可能的分开的IP地址存放在list里面。注意，list里面放的是分开的比如255这种
    public static void process(int index, List<String> list, String s, List<String> res){
        //base case。已经有四个单独的ip地址了，判断是否有效，如果都有效就放进res并返回
        boolean isValid = true;
        if (list.size() == 4){
            for (String temp : list){
                if (Integer.valueOf(temp) > 255 || (temp.length() > 1 && temp.charAt(0) == '0')
                        || index < s.length()){  //index < s.length()这句非常重要，判断是否已经搞完了
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<list.size(); i++){
                    sb.append(list.get(i));
                    if (i < list.size() - 1){
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        //递归体。每次可以选择1-3位数作为ip地址进行放入list里面
        for (int i=1; i<=3; i++){
            if (index + i > s.length()){
                break;
            }
            list.add(s.substring(index, index + i));
            process(index + i, list, s, res);
            list.remove(list.size() - 1);
        }
    }
}
