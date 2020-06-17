package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 18:33
 * @Title: 句子逆序
 * @Description: 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * @InputDescription: 将一个英文语句以单词为单位逆序排放。 I am a boy
 * @OuputDescription: 得到逆序的句子 boy a am I
 */
import java.util.*;
public class Test_0426_6 {
    public static void main(String[] args) {
        Test_0426_6 test = new Test_0426_6();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(test.reverse(sc.nextLine()));
        }
    }

    public String reverse(String sentence){
        String[] strlist = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strlist.length-1; i>=0; i--){
            sb.append(strlist[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
