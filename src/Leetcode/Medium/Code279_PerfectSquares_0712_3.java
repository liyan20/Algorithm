package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/12 16:30
 * @Title&Description: 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @Analysis:
 * 查找完全平方数。
 * 我觉得首先要对这个数找其最小的完全平方数，然后，减去再接着找，这样可能有问题吧
 * 换个想法：查找从这个数开始找完全平方数，然后递归找，如果不行，就换。有点像回溯啊感觉
 * @Summary:
 * @TimeConsuming:
 */
public class Code279_PerfectSquares_0712_3 {
    public static void main(String[] args) {
        System.out.println(numSquares(20));
    }
    public static int numSquares(int n) {
        if (n <= 0){
            return 0;
        }
        List<Integer> numsList = squareNumsList(n);
        int[] cache = new int[n+1];
        for (int i=0; i<cache.length; i++){
            cache[i] = -1;
        }
        return process(n, numsList, cache);
    }

    //递归函数。这个函数是还剩下rest的数的时候，需要多少个完全平方数
    public static int process(int rest, List<Integer> numsList, int[] cache){
        //越界情况
        if (rest < 0){
            return -1;
        }
        if (cache[rest] != -1){
            return cache[rest];
        }
        //base case。剩下的数是0了，当然不需要数了
        if (rest == 0){
            cache[rest] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<numsList.size(); i++){
            int res = process(rest - numsList.get(i), numsList, cache) + 1;
            if (res > 0){
                min = Math.min(min, res);
            }
        }
        cache[rest] = min;
        return min;
    }

    public static List<Integer> squareNumsList(int n){
        List<Integer> list = new ArrayList<>();
        for (int i=n; i>0; i--){
            if (Math.sqrt(i) == (int)Math.sqrt(i)){
                list.add(i);
            }
        }
        return list;
    }
}
