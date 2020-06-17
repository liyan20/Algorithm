package NowcoderAlgorithm_Part1_1.class02;


/**
 * @Author: xianz
 * @Date: 2020/6/4 17:39
 * @Title&Description: 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 * 示例1
 * 输入
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * @Analysis: 这个其实就是让不是字母的不动，英文字母的排个序就行了，再把非英文字符插回去
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02_0604_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(sort(str));
        }
    }
    public static String sort(String str){
        if (str == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //map用来保存非英文字符和位置，list用来保存英文字符
        //为了避免重复的情况，让key是index，value是字符
        Map<Integer,Character> map = new LinkedHashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            if (Character.isLetter(cur)){
                list.add(cur);
            }else {
                map.put(i, cur);
            }
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        if (!map.isEmpty()){
            for (Iterator<Integer> iter = map.keySet().iterator(); iter.hasNext();){
                int cur = iter.next();
                sb.insert(cur, map.get(cur));
            }
        }
        return sb.toString();
    }
}
