package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/7 09:35
 * @Title: 字符串中的第一个唯一字符
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"，返回 0.
 * s = "loveleetcode"，返回 2.
 * @Analysis: 放入LinkedHashMap中（因为要按照顺序放），如果已经有了，value为-1，如果没有，value为索引i。
 * 然后用Iterator，因为是按照顺序的，所以找到第一个value不是-1的key就行。如果找不到，最后返回-1
 * @ThinkingSteps:
 * @TimeConsuming: 26min
 */
import java.util.*;
public class Question03_0507_3 {
    public static void main(String[] args) {
        String s1 = "loveleetcode";
        String s2 = "lleetcode";
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));

    }
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        int index = -1;
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(!map.containsKey(temp)){
                map.put(temp,i);
            }else{
                map.put(temp,-1);
            }
        }
        Set<Character> set = map.keySet();
        for(Iterator<Character> iter = set.iterator();iter.hasNext();){
            int temp = map.get(iter.next());
            if(temp != -1){
                index = temp;
                break;
            }
        }
        return index;
    }
}
