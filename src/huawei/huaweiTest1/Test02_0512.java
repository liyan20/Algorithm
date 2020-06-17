package huawei.huaweiTest1;

/**
 * @Author: xianz
 * @Date: 2020/5/12 09:24
 * @Title: 字符集合
 * @Description: 输入一个字符串，求出该字符串包含的字符集合
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 输入例子1:
 * abcqweracb
 * 输出例子1:
 * abcqwer
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02_0512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            solution(str);
            System.out.println();
        }
    }

    public static void solution(String str){
        Set<Character> set = new LinkedHashSet<>();
        for (int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        for (Iterator<Character> iter = set.iterator();iter.hasNext();){
            System.out.print(iter.next());
        }
    }
}
