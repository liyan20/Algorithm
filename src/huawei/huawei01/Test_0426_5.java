package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 18:21
 * @Title: 字符个数统计
 * @Description: 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
 * 不在范围内的不作统计。注意是不同的字符
 * @InputDescription: 输入N个字符，字符在ACSII码范围内。 abc
 * @OuputDescription: 输出范围在(0~127)字符的个数。 3
 */
import java.util.*;
public class Test_0426_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Set<String> set = new HashSet<>();
            String str = sc.nextLine();
            for(int i=0;i<str.length();i++){
                set.add(String.valueOf(str.charAt(i)));
            }
            System.out.println(set.size());
        }
    }
}
