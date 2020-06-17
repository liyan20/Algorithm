package Test;

/**
 * @Author: xianz
 * @Date: 2020/5/18 19:19
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02_0518_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] slist = new String[n];
            String[] tlist = new String[n];
            for(int i=0;i<n;i++){
                slist[i] = sc.nextLine();
                tlist[i] = sc.nextLine();
            }
            for(int i=0;i<n;i++){
                System.out.println(findChar(slist[i],tlist[i]));
            }
        }
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
        for(int i=0;i<s.length();i++){
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
