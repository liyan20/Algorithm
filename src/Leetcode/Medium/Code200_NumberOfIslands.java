package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/23 20:57
 * @Title&Description: 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * @Analysis:
 * 这个是求岛屿的数量，说明连在一起的是算一个岛。
 * 题解的方法是对于每一个遇到的1，先进行dfs，把他四周的只要是1的都搞成0。
 * 如果是0的就返回
 *
 * @Summary:
 * @TimeConsuming:
 */
public class Code200_NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null){
            return 0;
        }
        int res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == '1'){
                    res++;
                    process(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void process(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == '0'){
            return;
        }
        //留下的就是当前的i,j符合要求并且数组是1的情况
        //给他置0
        grid[i][j] = '0';
        process(grid, i + 1, j);
        process(grid, i - 1, j);
        process(grid, i, j + 1);
        process(grid, i, j - 1);
    }
}
