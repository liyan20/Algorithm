package Leetcode.Hard;

/**
 * @Author: xianz
 * @Date: 2020/6/23 09:55
 * @Title&Description: 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 即皇后之间不能共行不能共列不能共斜线
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code52_NQueens_ii_0623_1 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(140));
    }

    public static int totalNQueens(int n) {
        if (n < 1){
            return 0;
        }
        //record数组代表着第i行的皇后在第几列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int index, int[] record, int n){
        //base case，如果index一直到了n的位置，说明这个排列方法可行，返回1就是一种排列方式
        if (index == n){
            return 1;
        }
        int res = 0;
        for (int j=0; j<n; j++){
            if (isValid(record, index, j)){
                record[index] = j;
                res += process1(index + 1, record, n);
            }
        }
        return res;
    }

    //判断第i行第j列的皇后和之前行的皇后是否有效，即判断和之前的皇后是否有共行共列共斜线的情况出现
    public static boolean isValid(int[] record, int index, int j){
        for (int k=0; k<index; k++){
            if ((j == record[k]) || (Math.abs(index - k) == Math.abs(j - record[k]))){
                return false;
            }
        }
        return true;
    }
}
