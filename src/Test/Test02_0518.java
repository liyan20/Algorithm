package Test;

/**
 * @Author: xianz
 * @Date: 2020/5/18 19:22
 * @Title&Description: 1.从头到尾遍历t字符串，再遍历s字符串，直到s的结束，找到所有能顺序提供t的那个子串
 * 然后是在s的剩下的找t剩下的。现在需要写找字符的程序
 * 思考：针对每一个t的char，如果找到一样的，删掉s里面的那个.
 * 下面是写一个函数，判断如果s找到底了，能不能找全t。只需要看看j是多少就行了.sb删完i就会变的
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02_0518 {
    public static void main(String[] args) {
        String s = "fasgesbet";
        String t = "sbtrht4wht";
        System.out.println(findChar(s, t));
    }

    public static String findChar(String s,String t){
        if(s.length()==0&t.length()==0){
            return "YES";
        }
        if(s.length()==0&t.length()!=0 || s.length()!=0&&t.length()==0){
            return "NO";
        }
        StringBuilder sbs = new StringBuilder();
        int j = 0;
        for(int i=0;i<s.length()&&j<t.length();i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }else {
                sbs.append(s.charAt(i));
            }
        }
        if(j == t.length()){
            return "YES";
        }
        //新的剩下的t，sbs就是还剩下的部分了，再来一次就行
        s = sbs.toString();
        t = t.substring(j);
        j = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
        }
        if(j == t.length()){
            return "YES";
        }else {
            return "NO";
        }
    }
}
