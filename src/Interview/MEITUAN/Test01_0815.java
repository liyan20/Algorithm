package Interview.MEITUAN;

/**
 * @Author: xianz
 * @Date: 2020/8/15 15:58
 * @Title&Description: 不一样的逆序对
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            solution(n);
        }
    }

//    public static void main(String[] args) {
//        solution(1);
//    }

    public static void solution(int n){
        List<String> list = new ArrayList<>();
        for (int i=0; i * 4 <= n; i++){  //这边要注意
            String rever = getRverse(i);
            if (String.valueOf(i * 4).equals(rever)){
                list.add(i + " " + rever);
            }
        }
        System.out.println(list.size());
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static String getRverse(int n){
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            char cur = str.charAt(i);
            if (cur != '0'){
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
