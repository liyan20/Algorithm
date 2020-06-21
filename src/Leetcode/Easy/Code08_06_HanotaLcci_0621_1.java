package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/21 11:52
 * @Title&Description: 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * 示例1:
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code08_06_HanotaLcci_0621_1 {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        hanota(A, B, C);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C){
        process(A, C, B, A.size());
    }

    //通用解法里面的把第几个放入哪个，这里面可以用取出list的最后一个数值来进行，之后是把最后一个数删掉，可以实现栈的作用
    //这里面是from,to,other分别代表A,C,B
    public static void process(List<Integer> A, List<Integer> C, List<Integer> B, int N){
        if (N == 1){
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            return;
        }
        process(A, B, C, N - 1);
        C.add(A.get(A.size() - 1));
        A.remove(A.size() - 1);
        process(B, C, A, N - 1);
    }

}
