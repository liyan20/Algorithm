package NowcoderAlgorithm_Part1_1.class15;

/**
 * @Author: xianz
 * @Date: 2020/6/28 17:42
 * @Title&Description: 象棋中马的跳法
 * 【题目】 请同学们自行搜索或者想象一个象棋的棋盘，然后把整个棋盘放入第一象限，
 * 棋盘的最左下 角是(0,0)位置。那么整个棋盘就是横坐标上9条线、纵坐标上10条线的一个区域。
 * 给你三个 参数，x，y，k，返回如果“马”从(0,0)位置出发，必须走k步，最后落在(x,y)上的方法数 有多少种
 *
 * 大概就是马要在0,0的位置，然后走K步，问最终落到指定位置a,b的数量有多少
 * 跟那个机器人一样的
 * 递归函数就是可变参数当前位置x,y，还有剩余步数。、base case是如果步数为0的时候，x，y落到了最终a,b的位置上
 * 就是1，如果不是就是0。如果越界那也是0
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_HorseJump {
    public static int dpWays(int a, int b, int s) {
        //三维DP数组，代表位置x,y和步数step
        int[][][] dp = new int[10][9][s + 1];
        //初始条件，步数为0时位置在a,b上面是1，其余都是0
        dp[a][b][0] = 1;
        //每一层的结果都只和上一层有关，和本层其他位置无关，所以最外层以step为参数
        for (int step = 1; step <= s; step++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    //getValue方法是如果不越界就返回值，越界返回0
                    dp[i][j][step] = getValue(dp, i - 1, j + 2, step - 1)
                        + getValue(dp, i + 1, j + 2, step - 1)
                        + getValue(dp, i + 2, j + 1, step - 1)
                        + getValue(dp, i + 2, j - 1, step - 1)
                        + getValue(dp, i + 1, j - 2, step - 1)
                        + getValue(dp, i - 1, j - 2, step - 1)
                        + getValue(dp, i - 2, j - 1, step - 1)
                        + getValue(dp, i - 2, j + 1, step - 1);
                }
            }
        }
        return dp[0][0][s];
    }

    public static int getValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) {
            return 0;
        }
        return dp[row][col][step];
    }
}
