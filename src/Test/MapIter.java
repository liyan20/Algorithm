package Test;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/22 10:21
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class MapIter {
    public static void main(String[] args) {
        MapIter mapIter = new MapIter();

        Map<String, String> map = new LinkedHashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int t : set){
            System.out.println(t);
        }
        map.put("1", "xiaqiu");
        map.put("2", "pangzi");
        map.put("3", "shouzi");
        for (Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }
        for (String temp : map.values()){
            System.out.println(temp);
        }
        for (String key : map.keySet()){
            System.out.println(key);
        }
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
