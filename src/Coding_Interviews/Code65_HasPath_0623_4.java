package Coding_Interviews;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/18 20:02
 * @Title&Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * @Analysis:
 * 分类是DFS，向下找有没有这个字符串
 * @Summary:
 * 这个题目很好，需要注意一下
 * @TimeConsuming:
 */
public class Code65_HasPath_0623_4 {
    //递归主函数
    //首先是向四个方向上递归。第二是已经用过的点不可以再用，所以是要避免四个方向返回来的情况
    //因为是字符数组所以不能用hashset，用一个数组保存一下
    //从左到右依次判断的方法需要一个index，而这个index不是矩阵的ij，而应该是判断是不是那个数组的k
    public static boolean process(char[][] matrix2D, int i, int j, int k, int[][] visited, char[] str){
        //这个是判断这次递归是否是有效的情况。前面一堆是临界条件，最后那个是判断数值是否对应还有是否用过
        //数值是否相等+是否用过需要注意
        if (i < 0 || i >= matrix2D.length || j < 0 || j >= matrix2D[0].length
                || k >= str.length || matrix2D[i][j] != str[k] || visited[i][j] == 1){
            return false;
        }
        //前面都不符合，到了这边，说明当前值是相等的，只要判断是不是到了str的最后一位就行
        if (k == str.length - 1 && matrix2D[i][j] == str[k]){
            return true;
        }
        visited[i][j] = 1;
        if (process(matrix2D, i + 1, j, k + 1, visited, str) ||
                process(matrix2D, i - 1, j, k + 1, visited, str) ||
                process(matrix2D, i, j + 1, k + 1, visited, str) ||
                process(matrix2D, i, j - 1, k + 1, visited, str)){
            return true;
        }
        visited[i][j] = 0;
        return false;
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || rows < 0 || cols < 0 || str == null || str.length < 1){
            return false;
        }
        //先给转成2D的矩阵
        char[][] matrix2D = new char[rows][cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                matrix2D[i][j] = matrix[i * cols + j];
            }
        }
        int[][] visited = new int[rows][cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (process(matrix2D, i, j, 0, visited, str)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
//        char[] str = {'b','c','c','e','d'};
        char[] str = "BCCED".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
