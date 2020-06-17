package Leetcode_EasyAlgorithm.Dynamic_Programming;

/**
 * @Author: xianz
 * @Date: 2020/5/16 14:09
 * @Title&Description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @Analysis: 方法1：每次爬楼梯可以是一阶，可以是二阶，所以可以是f(n)=f(n-1)+一阶，这一种，和f(n)=f(n-2)+二阶，这一种。
 * 总共是两种可能性，所以f(n)=f(n-1)+f(n-2)，斐波那契数列
 * @ThinkingSteps:
 * @TimeConsuming: 20min
 */
public class Question01_0516_1 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] result = new int[n+1];
        if(n<2){
            return 1;
        }
        result[0] = 1;
        result[1] = 1;
        //这里面的n对应了题目要求的n，因为我们从f(0)开始的
        for(int i=2;i<=n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[result.length-1];
    }
}
