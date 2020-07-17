package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/15 16:15
 * @Title&Description: 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @Analysis:
 * 需要对给的数字字符串进行分割。要保证每次分割之后，每个位置都是0-255之间
 * @Summary: 算是BFS吧
 * @TimeConsuming: 47min
 */
public class Code93_RestoreIPAddresses_0715_2 {
    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12){
            return res;
        }
        process(s, 0, new ArrayList<>(), res);
        return res;
    }

    //递归函数。每次选取一定的数，放入list里面去。最终返回条件是放了四个了就结束。
    //pos代表目前考虑到第几个位置了
    public static void process(String s, int pos, List<String> path, List<String> res){
        //返回条件，即结束的情况。装了四个字符串了。
        if (path.size() == 4){
            //如果每个字符串符合长度要求就放进res，如果有一个不符合要求就不放，后面直接返回。
            //还要加一个，有没有把整个字符串s遍历完；每个数是否大于255；两位以上数字开头不能是0
            boolean flag = true;
            for (String temp : path){
                if (temp.length() > 3 || pos < s.length()
                        || Integer.valueOf(temp) > 255 || (temp.length() > 1 && temp.charAt(0) == '0')){
                    flag = false;
                    break;
                }
            }
            if (flag){
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<path.size(); i++){
                    sb.append(path.get(i));
                    if (i != path.size()-1){
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        //每次可以选择1-3个数，我们使用for循环递归查找，因为substring是左闭右开的
        for (int i=1; i<=3; i++){
            if (pos + i > s.length()){
                break;
            }
            path.add(s.substring(pos, pos + i));
            process(s, pos + i, path, res);
            path.remove(path.size()-1);
        }
    }
}
