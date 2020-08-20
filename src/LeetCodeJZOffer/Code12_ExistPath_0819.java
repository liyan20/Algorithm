package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 14:17
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code12_ExistPath_0819 {

    public static void main(String[] args) {
        char[][] arr = {{'a', 'a'}};
        String word = "aa";
        System.out.println(exist(arr, word));
    }

    public static boolean exist(char[][] board, String word) {
        if(board == null || word == null){
            return false;
        }
        int[][] isVisited = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(process(i, j,0,isVisited,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 查找到i, j的位置，字符串的str[index ...]以后的情况，是否存在匹配的情况
     * @param i
     * @param j
     * @param index 字符串位置
     * @param isVisited 判断是否访问过
     * @param board
     * @param word
     * @return
     */
    public static boolean process(int i, int j, int index, int[][] isVisited, char[][] board, String word){
        //越界，已经访问过，以及字符不相等的情况。
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || isVisited[i][j] == 1 || index >= word.length() || word.charAt(index) != board[i][j]){
            return false;
        }
        //base case成功的情况
        if(index == word.length()-1 && word.charAt(index) == board[i][j]){
            return true;
        }
        //这次的选择及其影响
        isVisited[i][j] = 1;
        boolean res = process(i+1, j, index+1, isVisited, board, word) ||
                process(i-1, j, index+1, isVisited, board, word) ||
                process(i, j+1, index+1, isVisited, board, word) ||
                process(i, j-1, index+1, isVisited, board, word);
        //如果后续的选择是成功的直接返回，否则需要取消这次选择，是为回溯
        if(res){
            return true;
        }
        isVisited[i][j] = 0;  //取消选择
        return false;
    }
}
