package Test.NowCoder01;

/**
 * @Author: xianz
 * @Date: 2020/6/1 16:30
 * @Title&Description: 循环单词
 * 一个单词通过循环右移获得的单词，称为同一种循环单词。给n的单词，统计有多少个循环单词
 * @Analysis: 主要想法还是hashmap，把所有的情况都放到hashmap里面去
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0601_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = Integer.valueOf(sc.nextLine());
            List<String> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                list.add(sc.nextLine());
            }

        }
    }

    public static void solution(){

    }

    public static String rightStr(String str, int n){
        StringBuilder sb = new StringBuilder();
        n = n % str.length();
        sb.append(str.substring(str.length()-n, str.length()));
        sb.append(str.substring(0, str.length()-n));
        return sb.toString();
    }
}
