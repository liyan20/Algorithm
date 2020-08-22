package Interview.DIDI;

/**
 * @Author: xianz
 * @Date: 2020/8/21 19:34
 * @Title&Description: A+B问题又来了。
 *
 * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，
 * 现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 * 输入描述
 * 一个正整数n（100<n<2000）。
 * 输出描述
 * 第一行输出有多少对满足要求的数字。
 * 接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。
 * @Analysis:
 * 1068
 * 样例输出
 * 1
 * 524 544
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0821 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            solution(n);
        }
    }

    public static void solution(int n){
        List<String> list = new ArrayList<>();
        int p1;
        int p2;
        for (p1=102; p1<999; p1++){
            p2 = n - p1;
            if (isValid(p1, p2)){
                list.add(p1 + " " + p2);
            }
        }
        System.out.println(list.size());
        if (list.size() != 0){
            for (int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
        }

//        System.out.println(list);
    }

    //abc和acc
    public static boolean isValid(int a, int b){
        if (a > 999 || b > 999 || a < 100 || b < 100){
            return false;
        }
        String s1 = a + "";
        String s2 = b + "";
        return s1.charAt(0) == s2.charAt(0) && s1.charAt(1) != s1.charAt(2) &&
                s1.charAt(2) == s2.charAt(1) && s2.charAt(1) == s2.charAt(2);
    }

}
