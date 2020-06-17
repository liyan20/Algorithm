package huawei.huawei03;

/**
 * @Author: xianz
 * @Date: 2020/5/5 15:23
 * @Title: 按字节截取字符串
 * @Description: 输出为按字节截取的字符串。但是要保证汉字不被截半个，
 * 如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 * @Analysis: 1.可以的情况，汉字+字母 2.不可以的情况：汉字+字母+汉字，就是两个汉字之间不能有字母，
 * 如果有的话截止到汉字前面的那个字母
 * @ThinkingSteps: 汉字是2个字节，转2进制的话是大于8位的，字母等字符是1位的
 * @TimeConsuming: 33min
 */
import java.util.*;
public class Test_0505_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            int num = Integer.valueOf(sc.next());
            String target = str.substring(0, num);
            List<Integer> list = new ArrayList<>();
            int flag = 0;
            for(int i=0;i<target.length();i++){
                if(isChinese(target.charAt(i))){
                    list.add(i);
                }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i+1) - list.get(i) > 1){
                    flag = 1;
                    System.out.println(target.substring(0, list.get(i+1)));
                    break;
                }
            }
            if(flag == 0){
                System.out.println(target);
            }
        }
    }
    public static boolean isChinese(char cha){
        if(Integer.toBinaryString(cha).length()>8){
            return true;
        }else{
            return false;
        }
    }
}
