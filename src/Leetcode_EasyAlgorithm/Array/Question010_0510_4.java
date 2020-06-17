package Leetcode_EasyAlgorithm.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/5/10 21:04
 * @Title: 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question010_0510_4 {
    public static void main(String[] args) {
//        char[][] board =
//        System.out.println(isValidSudoku(board));


    }

    public static boolean isValid1(char[][] board){
        boolean flag = true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            if(!flag){
                break;
            }
            map.clear();
            for(int j=0;j<board[i].length;j++){
                if(map.containsKey(board[i][j]) && Character.isDigit(board[i][j])){
                    flag = false;
                    break;
                }else{
                    map.put(board[i][j],1);
                }
            }
        }
        return flag;
    }
    public static boolean isValid2(char[][] board){
        boolean flag = true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            if(!flag){
                break;
            }
            map.clear();
            for(int j=0;j<board.length;j++){
                if(map.containsKey(board[j][i]) && Character.isDigit(board[j][i])){
                    flag = false;
                    break;
                }else{
                    map.put(board[j][i],1);
                }
            }
        }
        return flag;
    }
    public static boolean isValid3(char[][] board){
        boolean flag = true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<3;i++){
            if(!flag){
                break;
            }
            for(int j=0;j<3;j++){
                if(!flag){
                    break;
                }
                map.clear();
                for(int k=i*3;k<i*3+3;k++){
                    if(!flag){
                        break;
                    }
                    for(int m=j*3;m<j*3+3;m++){
                        if(map.containsKey(board[k][m]) && Character.isDigit(board[k][m])){
                            flag = false;
                            break;
                        }else{
                            map.put(board[k][m],1);
                        }
                    }
                }
            }
        }
        return flag;

    }

    public static boolean isValidSudoku(char[][] board) {
        return isValid1(board) && isValid2(board) && isValid3(board);
    }

}
