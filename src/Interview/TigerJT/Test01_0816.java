package Interview.TigerJT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/8/16 16:49
 * @Title&Description:
 * 词频统计的题目，但是要求时间复杂度o(n)
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01_0816 {

    public static void main(String[] args) {
        String s = "taeeaaa";
        System.out.println(frequencySort(s));

    }

    public static String frequencySort (String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (!map.containsKey(cur)){
                map.put(cur, 1);
            }else {
                map.put(cur, map.get(cur) + 1);
            }
            max = Math.max(max, map.get(cur));
        }
        //以字符串最大长度为界限建立数组作为词频统计数组
        //按照词频统计的个数放进去，如果存在多个一样词频的就给加进去就完事了
        String[] arr = new String[s.length()];
        Arrays.fill(arr, null);
        for (Map.Entry entry : map.entrySet()){
            char key = (char)entry.getKey();
            int value = (int)entry.getValue();
            StringBuilder temp = new StringBuilder();
            for (int i=0; i<value; i++){
                temp.append(key);
            }
            if (arr[value] == null){
                arr[value] = temp.toString();
            }else {
                arr[value] = arr[value] + temp.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--){
            if (arr[i] != null){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
