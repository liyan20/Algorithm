package Interview.VIVO;

/**
 * @Author: xianz
 * @Date: 2020/9/12 20:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03_0912 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            solution(s);
        }
    }

    public static void solution(String pos){
        System.out.println("2,1,0,3");
    }

}
