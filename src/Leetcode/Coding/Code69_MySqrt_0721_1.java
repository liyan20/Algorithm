package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/7/21 06:56
 * @Title&Description: 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @Analysis:
 * 找到平方根，可以直接遍历，也可以二分查找。
 * @Summary:
 * @TimeConsuming:
 */
//主要目标是查找k^2 <= x的最大的k就行，使用二分算法。二分算法的写法需要注意一下。
// 诸如循环的条件，mid位运算的注意点，新的L或R的取值等等
public class Code69_MySqrt_0721_1 {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int ans = 0;
        int L = 0, R = x;
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if ((long)mid * (long)mid <= x){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return ans;
    }
}
