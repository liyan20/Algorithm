package NowcoderAlgorithm_Part1_1.class02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/4 18:00
 * @Title&Description: 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
 * 给定一个整数数组A及它的大小n，请返回最短子数组的长度。
 * 测试样例：
 * [1,5,3,4,2,6,7],7
 * 返回：4
 * @Analysis: 这题目不知道干啥的，有啥是最短的，不就一个吗
 * 我是把他排序，然后看哪个地方是不一样的，然后第一个不一样的和最后一个不一样的相减
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Test03_0604_5 {
    public static void main(String[] args) {
        int[] a = {1,5,3,4,2,6,7};
        System.out.println(findShortest(a,7));
    }

    public static int findShortest(int[] A, int n) {
        int[] help = new int[A.length];
        for (int i=0; i<A.length; i++){
            help[i] = A[i];
        }
        Arrays.sort(help);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<A.length; i++){
            if (A[i] != help[i]){
                list.add(i);
            }
        }
        return list.size() == 0 ? 0 : list.get(list.size()-1) - list.get(0) + 1;
    }
}
