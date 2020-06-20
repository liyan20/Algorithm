package NowcoderAlgorithm_Part1_1.class08;

import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/20 11:59
 * @Title&Description: 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 *
 * @Analysis:
 * 一个很朴素的方法：左中右三个柱子，我们要求是从左拿到右，但是只能小的叠在大的上面，所以有如下的流程：有N个盘子
 * leftToRight(N);
 * 0.如果N == 1，直接拿就完事了
 * 1.把1-N-1个盘子从左边拿到中间 midToRight(n-1);
 * 2.把第N个盘子从左边拿到右边
 * 3.把剩下的1-N-1个盘子从中间拿到右边 midToRight(n-1);
 * 然后，把盘子从中间拿到右边的midToRight(n-1)，根左到右一样的，先把n-2拿出来，这种。最终发现要写6个函数
 * 三个柱子来回换，互相调用。
 *
 * 汇总方法：
 * 设定from, other, to三个变量，更新上面的三个步骤：
 * 0.如果N==1，直接拿。这个也是递归的结束条件
 * 1.将0-N-1个盘子从from拿到other
 * 2.将第N个盘子从from拿到to
 * 3.将0-N-1个盘子从other拿到to
 * 其中，是根据输入数据的不同，在每次递归的时候对应的from,to,other都不一样
 * @Summary:
 * 递归要不然用return，要不然是用if else，在void方法的时候
 * @TimeConsuming:
 */
public class Code01_Hanoi {
    public static void main(String[] args) {
        System.out.println("a" + '1');
        func(3, "左", "右", "中");
    }

    //整合想法
    public static void func(int N, String from, String to, String other){
        if (N == 1){
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        func(N - 1 , from, other, to);
        System.out.println("Move " + N + " from " + from + " to " + to);
        func(N - 1, other, to, from);
    }

    //直观的想法
    public static void leftToRight(int n) {
        if(n== 1) {
            System.out.println("Move 1 from left to right");
            return ;
        }
        leftToMid(n-1);
        System.out.println("Move " +n + " from left to right");
        midToRight(n-1);
    }
    public static void leftToMid(int n) {
        if(n== 1) {
            System.out.println("Move 1 from left to mid");
            return ;
        }
        leftToRight(n-1);
        System.out.println("Move " +n + " from left to mid");
        rightToMid(n-1);
    }
    public static void midToRight(int n) {
    }
    public static void rightToMid(int n) {
    }
}
