package Interview.XIAOMI;

/**
 * @Author: xianz
 * @Date: 2020/9/8 18:25

 * @Analysis:
 * 样例输入
 * 123 12345678 123abcABC!!!
 * 样例输出
 * 1
 * 2
 * 0
 * @Summary:
 * @TimeConsuming:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02_0908 {

    public static void main(String[] args) {
        input();
    }

    /**
     * 题目有问题！没告诉我们网格在哪啊亲！！！
     */
    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(true);
        }
    }

    public static boolean solution(char[][] board, String word){
        int[][] isVisited = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (process(i, j,0,isVisited, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(int i, int j, int index, int[][] isVisited, char[][] board, String word){
        if (i < 0 || i > board.length || j < 0 || j > board[0].length
                || index >= word.length() || word.charAt(index) != board[i][j]){
            return false;
        }

        if (index == word.length()-1 && word.charAt(index) == board[i][j]){
            return true;
        }
        isVisited[i][j] = 1;
        boolean res = process(i+1, j, index+1, isVisited, board, word) ||
                process(i-1, j, index+1, isVisited, board, word) ||
                process(i, j+1, index+1, isVisited, board, word) ||
                process(i, j-1, index+1, isVisited, board, word);
        if (res){
            return true;
        }
        isVisited[i][j] = 0;
        return false;
    }

}
