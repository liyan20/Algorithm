package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 09:21
 * @Title: 【中级】单词倒排
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis: 1.针对字符串里面的单词间隔符，首先要去掉重复的，并且反转后要以空格替代
 * @TimeConsuming: 25min
 */
import java.util.*;
public class Test_0503_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
//            把字母保存，不是字母的换成空格
            for(int i=0;i<str.length();i++){
                char temp = str.charAt(i);
                if(Character.isLetter(temp)){
                    sb.append(temp);
                }else{
                    sb.append(" ");
                }
            }

//            把多余的空格去掉，倒着保存
            String[] list = sb.toString().split(" ");
            for(int i=list.length-1; i>=0;i--){
                if(!list[i].equals("")){
                    sb2.append(list[i]+" ");
                }
            }
//            删掉最后一个多余的空格
            sb2.deleteCharAt(sb2.toString().length()-1);
            System.out.println(sb2.toString());
        }
    }
}
