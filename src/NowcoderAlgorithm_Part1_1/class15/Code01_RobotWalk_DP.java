package NowcoderAlgorithm_Part1_1.class15;

/**
 * @Author: xianz
 * @Date: 2020/6/27 09:58
 * @Title&Description:
 * 用动态规划的方法。感觉这种动态规划就是把递归从大的问题回到小问题的思想，
 * 给换成我们从小的问题开始，一直回到大的问题这边，维护一张表就行，一般就是数组。
 * 这个表的维度和我们的递归函数的可变参数有关，如果就一个参数，就搞一维表，如果是两个可变参数，就搞二维表。
 * 但是首先你要把递归给写出来才行
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_RobotWalk_DP {
    public static void main(String[] args) {
        System.out.println(walkDP(5,2,3,3));
    }

    //N是总的位置，K是走多少步，start是起点，end是结束时候要在哪
    //根据递归函数分析，我们的变量参数是start和K，即当前到哪了还有还剩下多少步。
    //总的数量N和结束的位置end是不变的，所以需要一个二维的表。行和列分别是cur当前位置和rest还剩下的步数
    public static int walkDP(int N, int start, int end, int K){
        if (N < 2 || K < 1 || start < 1 || start > N || end < 1 || end > N){
            return 0;
        }
        //新建dp表，行数是0-N，列数是0-K。
        int[][] dp = new int[N+1][K+1];
        //先把不依赖于其他位置的dp位置给填上，就是递归里面的base case的情况
        //即rest==0的时候，没路走了，如果当前位置到了end就是1如果不是就是0
        //因为java里面初始化数组就是0，所以只需要改1就行
        dp[end][0] = 1;   //这是dp数组的初始化，第0列填完了

        //接下来开始填表，从第1列开始
        //根据递归函数，我们先有了第一列的数值。然后如果是第一行的，那么就是等于左下角的
        //如果是第N行的，那就是等于左上角的，如果是中间的普通位置，那就是等于左上角的加上左下角的和
        //这些计算方法就是等于递归函数里面的不同情况的返回值
        //计算的顺序应该是按照我们举具体参数的例子的时候填写整张表的顺序来的
        for (int col = 1; col <= K; col++){
            //这是第一行和第N行的特殊情况
            dp[1][col] = dp[2][col-1];
            dp[N][col] = dp[N-1][col-1];
            //这是中间普通位置的情况
            for (int row = 2; row < N; row++){
                dp[row][col] = dp[row-1][col-1] + dp[row+1][col-1];
            }
        }
        return dp[start][K];
    }
}
