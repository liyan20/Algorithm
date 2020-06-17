package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/27 21:43
 * @Title: 简单密码
 * @Description:
 * @InputDescription: 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾  YUANzhi1987
 * @OuputDescription: 输出渊子真正的密文 zvbo9441987
 */
import java.util.*;
public class Test_0427_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++){
                if(Character.isLowerCase(str.charAt(i))){
                    sb.append(turnLowerCase(str.charAt(i)));
                }else if(Character.isUpperCase(str.charAt(i))){
                    sb.append(turnUpperCase(str.charAt(i)));
                }else{
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static char turnUpperCase(char input) {
        if (input == 'Z') {
            return 'a';
        } else {
            return (char) (Character.toLowerCase(input) + 1);
        }
    }

    public static char turnLowerCase(char input) {
        if (input >= 'a' && input <= 'c') {
            return '2';
        } else if (input >= 'd' && input <= 'f') {
            return '3';
        } else if (input >= 'g' && input <= 'i') {
            return '4';
        } else if (input >= 'j' && input <= 'l') {
            return '5';
        } else if (input >= 'm' && input <= 'o') {
            return '6';
        }else if (input >= 'p' && input <= 's'){
            return '7';
        }else if (input >= 't' && input <= 'v'){
            return '8';
        }else {
            return '9';
        }
    }
}