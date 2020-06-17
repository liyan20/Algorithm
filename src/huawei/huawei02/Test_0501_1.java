package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/1 07:59
 * @Title: 字符串排序
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * 用时60分钟
 */
import java.util.*;
public class Test_0501_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strlist = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<strlist.length; i++){
                sb.append(Solution(strlist[i]));
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
    public static String Solution(String input){
        List<Character> list = new LinkedList<>();
        Map<Integer,Character> map = new TreeMap<>();
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            if(Character.toLowerCase(temp) >= 'a' && Character.toLowerCase(temp) <= 'z'){
                list.add(input.charAt(i));
            }else{
                map.put(i, temp);
            }
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size();i++){
            sb.append(list.get(i));
        }
        if(!map.isEmpty()){
            Set<Integer> set = map.keySet();
            for(Iterator<Integer> iter = set.iterator(); iter.hasNext(); ){
                int temp = iter.next();
                sb.insert(temp, map.get(temp));
            }
        }
        return sb.toString();
    }
}