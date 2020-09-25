package Interview.BAIDU;

/**
 * @Author: xianz
 * @Date: 2020/9/3 20:08
 * @Title&Description:
小度的机器人
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小度新买了一个机器人玩具。我们可以把这个机器人放到一个二维坐标上，
它的初始位置为（x0,y0）。然后给出一串指令，指令包含四个字符U、D、L和R，分别表示上、下、左、右。
每遇到一个指令字符，机器人将朝相应的方向移动一格。请输出机器人的最后位置。

输入描述
单组输入，输入两行。
第一行两个整数表示起始位置x0和y0，两个整数之间用空格隔开。（起始坐标在±10000以内）
第二行一个字符串表示指令集（指令集长度不超过10000）。
样例输入
0 0
LLRR
样例输出
0 0
输出描述
输出两个整数，表示机器人的最终位置坐标，两个整数之间用空格隔开。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Arrays;
import java.util.Comparator;


import java.util.Scanner;

public class Test01_0903 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
//            String s1 = sc.nextLine();
            long x0 = sc.nextLong();
            long y0 = sc.nextLong();
            sc.nextLine();

//            long x0 = Long.valueOf(s1.split(" ")[0]);
//            long y0 = Long.valueOf(s1.split(" ")[1]);
            String s2 = sc.nextLine();
            solution(x0, y0, s2);
        }
    }

    //指令包含四个字符U、D、L和R，分别表示上、下、左、右。
    public static void solution(long x, long y, String s2){
        char[] arr = s2.toCharArray();
        for (int i=0; i<arr.length; i++){
            char cur = s2.charAt(i);
            if (cur == 'U'){
                x = x-1;
            }else if (cur == 'D'){
                x = x+1;
            }else if (cur == 'L'){
                y = y-1;
            }else if (cur == 'R'){
                y = y+1;
            }else {
                continue;
            }
        }
        System.out.println(x + " " + y);
    }

}
