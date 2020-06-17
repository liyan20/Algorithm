package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/2 08:33
 * @Title: 字符串加解密
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @TimeConsuming: 33min18s
 */
import java.util.*;
public class Test_0502_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(Encrypt(str1));
            System.out.println(unEncrypt(str2));
        }
    }

    public static String Encrypt(String input){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            char encrypt ='0';
            if(Character.toLowerCase(temp) == 'z'){
                encrypt = Character.isLowerCase(temp) ? 'A' : 'a';
            }else if(Character.toLowerCase(temp)>='a' && Character.toLowerCase(temp)<'z'){
                encrypt = Character.isLowerCase(temp) ? Character.toUpperCase((char)(temp+1)) : Character.toLowerCase((char)(temp+1));
            }else if(temp == '9'){
                encrypt = '0';
            }else if(Character.isDigit(temp)){
                encrypt = (char)(temp+1);
            }else{
                encrypt = temp;
            }
            sb.append(encrypt);
        }
        return sb.toString();
    }

    public static String unEncrypt(String input){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            char encrypt ='0';
            if(Character.toLowerCase(temp) == 'a'){
                encrypt = Character.isLowerCase(temp) ? 'Z' : 'z';
            }else if(Character.isLetter(temp)){
                encrypt = Character.isLowerCase(temp) ? Character.toUpperCase((char)(temp-1)) : Character.toLowerCase((char)(temp-1));
            }else if(temp == '0'){
                encrypt = '9';
            }else if(Character.isDigit(temp)){
                encrypt = (char)(temp-1);
            }else{
                encrypt = temp;
            }
            sb.append(encrypt);
        }
        return sb.toString();
    }
}
