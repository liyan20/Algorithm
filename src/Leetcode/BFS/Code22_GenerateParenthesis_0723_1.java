package Leetcode.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/23 09:18
 * @Title&Description: 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @Analysis:
 * 貌似我是想复杂了。path加上（的时候，任何时候只要有都可以，但是右括号必须是有左括号才行，所以右括号数量必须小于左括号。
 * 这题的代码很简洁，下面的两个判断应该就是剪枝操作，化简了一些不必要的递归。
 * 我之前在疑惑能回来吗，这样看起来应该是可以的，下面第一个if里面的递归执行完之后，一直往下递归，结束后会一直返回
 * 这样就可以接着下面的开始新的路径开始走，就是放又括号的那个。
 * @Summary:
 * @TimeConsuming:
 */
public class Code22_GenerateParenthesis_0723_1 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0){
            return res;
        }
        process(n, n, "", res);
        return res;
    }

    public static void process(int left, int right, String path, List<String> res){
        //base case
        if (left == 0 && right == 0){
            res.add(path);
            return;
        }
        //递归体
        if (left > 0){
            process(left-1, right, path+"(", res);
        }
        if (right > left){
            process(left, right-1, path+")", res);
        }
    }
}
