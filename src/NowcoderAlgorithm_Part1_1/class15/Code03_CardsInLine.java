package NowcoderAlgorithm_Part1_1.class15;

/**
 * @Author: xianz
 * @Date: 2020/6/28 17:01
 * @Title&Description:
 * 这是之前那个一个一维数组取数字的先手后手的问题，每个人要在数组的最左边和最右边选一个，然后给另一个人取
 * 每个人都绝对理性，求最终获胜者的取得的最大的数之和。
 * 这个在递归里面是先手的话选择左边或者右边然后是剩下的给后手，二种选择最大值
 * 后手的话是左或者右给先手选过之后的剩下的最小的，因为是绝对理性所以先手只会给后手留下最小的选择
 * @Analysis:
 * 改动态规划：
 * 1.尝试，写出递归式，写出来了，并且是两个递归函数，可变参数是每次的范围L,R，所以是两张二维的表
 * 2.给定参数，画出表，看看怎么填写这张表
 * 3.结论是，每张表的L<R的时候是无效的，然后对角线L == R的时候就是base case，先手f表是1，后手s表是0
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_CardsInLine {
    public static void main(String[] args) {
        int[] arr = {1,100,2,5,6,7,2,45,547,235,34};
        System.out.println(dp(arr));
    }
    public static int dp(int[] arr) {
        if(arr == null || arr.length < 1) {
            return 0;
        }
        int N = arr.length;
        //定义两个表
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        //初始化
        for(int i = 0 ; i < N;i++) {
            f[i][i] = arr[i];
        }
        //填写表格的时候是每个对角线的顺序
        for (int col = 1; col < N; col++){
            int i = 0;
            int j = col;
            while (i < N && j < N){
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
                i++;
                j++;
            }
        }
        return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
    }
}
