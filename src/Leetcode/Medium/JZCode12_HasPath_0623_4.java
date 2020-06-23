package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/23 18:30
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode12_HasPath_0623_4 {
    //这是leetcode的版本
    public static boolean exist(char[][] board, String word){
        if (board == null || board.length < 1 || board[0].length < 1 ||
                word == null || word.length() < 1){
            return false;
        }
        //先给转成2D的矩阵
        int[][] visited = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (process2(board, i, j, 0, visited, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process2(char[][] board, int i, int j, int k, int[][] visited, String word){
        //这个是判断这次递归是否是有效的情况。前面一堆是临界条件，最后那个是判断数值是否对应还有是否用过
        //数值是否相等+是否用过需要注意
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || k >= word.length() || board[i][j] != word.charAt(k) || visited[i][j] == 1){
            return false;
        }
        //前面都不符合，到了这边，说明当前值是相等的，只要判断是不是到了str的最后一位就行
        if (k == word.length() - 1 && board[i][j] == word.charAt(k)){
            return true;
        }
        visited[i][j] = 1;
        if (process2(board, i + 1, j, k + 1, visited, word) ||
                process2(board, i - 1, j, k + 1, visited, word) ||
                process2(board, i, j + 1, k + 1, visited, word) ||
                process2(board, i, j - 1, k + 1, visited, word)){
            return true;
        }
        visited[i][j] = 0;
        return false;
    }
}
