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

        float f = 14.45f;
        int i = 20;
        System.out.println("re" + f + i);



//        int i = 2;
//        int j = 10;
//        i = i ^ j;
//        j = i ^ j;
//        i = i ^ j;
////        swap(a,b);
//        System.out.println(i);
//        System.out.println(j);
//        StringBuilder sb = new StringBuilder();
//        sb.append("1");
//        sb.insert(1, "2");
//        System.out.println(sb.toString());
    }
    public static void swap( int i, int j){
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
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
