package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/28 18:58
 * @Title: 密码验证合格程序
 * @Description: 密码要求:1.长度超过8位  2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复  说明:长度超过2的子串
 * @InputDescription: 一组或多组长度超过2的子符串。每组占一行 021Abc9000 021Abc9Abc1
 * @OuputDescription: 如果符合要求输出：OK，否则输出NG OK NG
 */
import java.util.*;
public class Test_0428_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            if(isOverLength(str) && isContainSymbol(str) && isSameSubstring(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }

    public static boolean isOverLength(String input){
        if(input.length()>8){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isContainSymbol(String input){
        int upper = 0;
        int lower = 0;
        int num = 0;
        int other = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)>='A' && input.charAt(i)<='Z'){
                upper = 1;
            }else if(input.charAt(i)>='a' && input.charAt(i)<='z'){
                lower = 1;
            }else if(input.charAt(i)>='0' && input.charAt(i)<='9'){
                num = 1;
            }else{
                other = 1;
            }
        }
        int flag = upper+lower+num+other;
        if(flag>=3){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isSameSubstring(String input){
        Set<String> set = new HashSet<>();
        for(int i=0;i<input.length()-2; i++){
            set.add(input.substring(i, i+3));
        }
        if(set.size()<input.length()-2){
            return false;
        }else{
            return true;
        }
    }
}
