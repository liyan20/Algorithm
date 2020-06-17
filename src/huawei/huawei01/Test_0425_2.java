package huawei.huawei01;



/**
 * @Author: xianz
 * @Date: 2020/4/25 10:17
 * @Title: 计算字符个数
 * @Description: 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
import java.util.*;
public class Test_0425_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = sc.nextLine();

        int num = 0;
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)+"").equalsIgnoreCase(s)){
                num++;
            }
        }
        System.out.println(num);
    }
}
