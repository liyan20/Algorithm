package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 10:39
 * @Title:  数字颠倒
 * @Description: 描述：输入一个整数，将这个整数以字符串的形式逆序输出，
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * @InputDescription: 输入一个int整数 1516000
 * @OuputDescription: 将这个整数以字符串的形式逆序输出 0006151
 */
import java.util.*;
public class Test_0426_1 {
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
