package Leetcode.Medium;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/5 09:39
 * @Title&Description: 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @Analysis:
 * 有一个办法可以判断是不是异位词，就是对字符串转成字符数组后进行排序，如果是相等的，那就是的
 * @Summary:
 * @TimeConsuming:
 */
public class Code49_GroupAnagrams_0705_2 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }

    //使用一个map，key是排序后的字符串，value是具有相同的字符串的输入那些字符串，即为异位词
    //最后把map的value弄到list里面输出就行了
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length < 1){
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            String temp =  charArrayToSortedString(strs[i].toCharArray());
            if (!map.containsKey(temp)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }else {
                List<String> list = map.get(temp);
                list.add(strs[i]);
                map.put(temp, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length < 1){
            return result;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            String temp =  charArrayToSortedString(strs[i].toCharArray());
            if (!map.containsKey(temp)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(temp, list);
            }else {
                List<Integer> list = map.get(temp);
                list.add(i);
                map.put(temp, list);
            }
        }
        for (String str : map.keySet()){
            List<String> strList = new ArrayList<>();
            List<Integer> indexList = map.get(str);
            for (int i : indexList){
                strList.add(strs[i]);
            }
            result.add(strList);
        }
        return result;
    }

    public static String charArrayToSortedString(char[] charArr){
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charArr.length; i++){
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}
