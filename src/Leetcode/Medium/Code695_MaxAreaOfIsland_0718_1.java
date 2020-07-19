package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/18 16:05
 * @Title&Description: 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code695_MaxAreaOfIsland_0718_1 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                int res = process(grid, i, j);
                max = Math.max(max, res);
            }
        }
        return max;
    }

    //这个是递归函数，用于将当前位置的是属于岛屿的面积。
    public static int process(int[][] grid, int i, int j){
        //返回条件。越界即返回
        //当当前位置不是岛屿而是海的时候也返回
        //因为我们的函数是当前是岛的前提下，对四周进行搜索，找到整个岛的范围，记录面积的。
        //如果是水，那么就直接返回，因为如果你还是按照四周搜索，那可能就不是一片岛屿，整个逻辑就乱了。
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        //对当前是岛屿的位置进行四个方向的搜索，并且加上当前的这个面积1
        return process(grid, i + 1, j) +
                process(grid, i - 1, j) +
                process(grid, i, j + 1) +
                process(grid, i, j - 1) + 1;
    }
}
