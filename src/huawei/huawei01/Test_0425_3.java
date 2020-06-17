package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 10:48
 * @Title: 字符串分隔
 * @Description: •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @InputDescription: 连续输入字符串(输入2次,每个字符串长度小于100)
 * @OuputDescription: 输出到长度为8的新字符串数组
 */
import java.util.*;
public class Test_0425_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            if(str != null){
                for(int i=0; i<str.length(); i++){
                    sb.append(str.charAt(i));
                }
                int num2 = str.length() % 8;
                if(num2 != 0){
                    for(int i=0; i<(8-num2); i++){
                        sb.append(0);
                    }
                }
                int num1 = sb.toString().length() / 8;
                for(int i=0;i<num1;i++){
                    System.out.println(sb.toString().substring(i*8, i*8+8));
                }
            }
        }
    }
}
