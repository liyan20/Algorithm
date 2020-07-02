package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/7/2 18:53
 * @Title&Description: 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @Analysis:
 * 典型的回溯，不能重复。其实回溯就是一种递归思路而已。
 * 首先要先定义一张表，里面是数字和对应的字母。
 * 这是回溯吗，感觉不是啊，就是各种可能的情况啊
 * @Summary:
 * @TimeConsuming:
 */
public class Code17_LetterCombinationsPhoneNumber_0702_2 {
    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        //这一步需要注意一下，可能为空的字符串
        if (digits == null || digits.length() < 1){
            return list;
        }
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jlk");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        process(0, digits, "", map, list);
        return list;
    }

    //先想想几个参数。首先是到第几个字符了，index算一个
    //然后就是当前已经搞成的String，这次我用List吧，可能以后还会遇到
    //还有一个就是题目要求的，放着所有的可能情况的list
    public static void process(int index, String digits, String path, Map<Integer, String> map, List<String> list){
        //base case
        if (index == digits.length()){
            list.add(path);
            return;
        }
        int num = Integer.valueOf(String.valueOf(digits.charAt(index)));
        String charList = map.get(num);
        for (int i=0; i<charList.length(); i++){
            process(index + 1, digits, path + charList.charAt(i), map, list);
        }
    }
}
