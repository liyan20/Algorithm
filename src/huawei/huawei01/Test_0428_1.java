package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/28 09:07
 * @Title: 删除字符串中出现次数最少的字符
 * @Description: 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * @InputDescription: 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。 abcdd
 * @OuputDescription: 删除字符串中出现次数最少的字符后的字符串。 dd
 */
import java.util.*;
public class Test_0428_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else{
                    map.put(str.charAt(i), 1);
                }
            }
            List<Integer> list = new ArrayList<>(map.values());
            int min = Collections.min(list);
//            System.out.println(Collections.min(list));
            for(int i=0; i<str.length(); i++){
                if(map.get(str.charAt(i)) != min){
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
