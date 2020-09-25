package Interview.VIVO;

/**
 * @Author: xianz
 * @Date: 2020/9/12 20:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0912 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(solution(s));
        }
    }

    public static String solution(String s){
        if (s == null || s.length() == 1){
            return s;
        }
        int left = 0, right = s.length()-1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                boolean flag1 = true, flag2 = true;
                for (int i=left+1, j=right; i<j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        flag1 = false;
                        break;
                    }
                }
                for (int i=left, j=right-1; i<j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        flag2 = false;
                        break;
                    }
                }
                if (flag1){
                    return getString(s, left);
                }else if (flag2){
                    return getString(s, right);
                }else {
                    return "false";
                }
            }
        }
        return s;
    }

    public static String getString(String s, int index){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (i != index){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
