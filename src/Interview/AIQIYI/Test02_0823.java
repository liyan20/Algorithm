package Interview.AIQIYI;

/**
 * @Author: xianz
 * @Date: 2020/8/23 15:17
 * @Title&Description: 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，
 * 分别表示向北、向南、向东、向西移动一个单位。机器人从二维平面上的原点 (0, 0) 处开始出发，
 * 按 path 所指示的路径行走。如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，
 * 请返回 True ；否则，返回 False 。
 * 输入描述
 * 一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 输出描述
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * @Analysis:
 * ESSWNEE
 * 样例输出
 * True
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Scanner;
public class Test02_0823 {

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

    public static void solution(String s){
        if (s == null || s.length() < 2){
            System.out.println("False");
            return;
        }
        int[][] arr = new int[s.length()+1][s.length()+1];
        int i=0, j=0;
        arr[0][0] = 1;
        for (int index=0; index<s.length(); index++){
            char cur = s.charAt(index);
            if (cur == 'N'){
                i--;
            }else if (cur == 'S'){
                i++;
            }else if (cur == 'W'){
                j--;
            }else if (cur == 'E'){
                j++;
            }
            if(cur != 'N' && cur != 'S' && cur != 'W' && cur != 'E'){
                continue;
            }
            i = i >= 0 ? i : 0;
            j = j >= 0 ? j : 0;
            if (arr[i][j] == 1){
                System.out.println("True");
                return;
            }else {
                arr[i][j] = 1;
            }
        }
        System.out.println("False");
    }

}
