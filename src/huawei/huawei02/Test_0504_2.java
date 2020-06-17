package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/4 07:18
 * @Title: 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming: 4min
 */
import java.util.*;
public class Test_0504_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int letterNum = 0;
            int digitNum = 0;
            int blankNum = 0;
            int otherNum = 0;
            for(int i=0;i<str.length();i++){
                char temp = str.charAt(i);
                if(Character.isLetter(temp)){
                    letterNum++;
                }else if(Character.isDigit(temp)){
                    digitNum++;
                }else if(temp == ' '){
                    blankNum++;
                }else {
                    otherNum++;
                }
            }
            System.out.println(letterNum);
            System.out.println(blankNum);
            System.out.println(digitNum);
            System.out.println(otherNum);
        }
    }
}
