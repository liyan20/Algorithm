package Test;

/**
 * @Author: xianz
 * @Date: 2020/6/3 11:14
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class test0603 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.insert(1, "2");
        System.out.println(sb.toString());
    }

    public static char findMostChar(String str){
        if (str == null){
            return ' ';
        }
        int max = 0;
        char maxChar = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            if (!map.containsKey(temp)){
                map.put(temp, 1);
            }else {
                map.put(temp, map.get(temp)+1);
                if(max < map.get(temp)){
                    max = map.get(temp);
                    maxChar = temp;
                }
            }
        }
        return maxChar;
    }
}
