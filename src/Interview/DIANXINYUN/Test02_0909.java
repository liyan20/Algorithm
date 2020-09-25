package Interview.DIANXINYUN;

/**
 * @Author: xianz
 * @Date: 2020/9/9 20:54
 * @Title&Description:
 * abcd+bcda = 8888
 * 求a,b,c,d的值。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;

public class Test02_0909 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        solution();
    }

    public static void solution(){
        List<String> list = new ArrayList<>();
        for (int i=0; i<9999; i++){
            if (getReverse(i)){
                StringBuilder sb = new StringBuilder(i + "");
                while (sb.length() < 4){
                    sb.insert(0, 0);
                }
                list.add(sb.toString());
            }
        }
        for (int i=0; i<list.size(); i++){
            String s = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<s.length(); j++){
                sb.append(s.charAt(j));
                if (j != s.length() - 1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean getReverse(int n){
        StringBuilder sb = new StringBuilder(n + "");
        while (sb.length() < 4){
            sb.insert(0, 0);
        }
        String s = sb.toString();
        String res = s.substring(1) + s.charAt(0);
        return Integer.valueOf(res) + n == 8888;
    }

}
