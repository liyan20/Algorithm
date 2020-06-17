package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 10:50
 * @Title:  字符串反转
 * @Description: 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * @InputDescription: 输入N个字符 abcd
 * @OuputDescription: 输出该字符串反转后的字符串 dcba
 */
import java.util.*;
public class Test_0426_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=str.length()-1; i>=0; i--){
                sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
