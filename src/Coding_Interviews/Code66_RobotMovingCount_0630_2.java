package Coding_Interviews;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/30 09:23
 * @Title&Description: 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @Analysis:
 * 这个机器人一次只能上下左右的走，所以说如果四周都走不了的时候，机器人是不能再往前的，即使前面的位置满足条件
 * 初步看应该是可以用递归来做的
 * 好像不是，感觉应该是回溯，其实是void的递归
 * @Summary:
 * @TimeConsuming: 35min
 */
public class Code66_RobotMovingCount_0630_2 {
    public static void main(String[] args) {
        int threshold = 15;
        int rows = 20;
        int cols = 20;
        System.out.println(movingCount(threshold, rows, cols));
    }

    public static int movingCount(int threshold, int rows, int cols){
        Set<String> set = new HashSet<>();
        process(0, 0, threshold, rows, cols, set);
        return set.size();
    }

    //我设计一个hashset，保存目前可以的位置。可变参数是当前的位置。
    //void的递归
    public static void process(int i, int j, int threshold, int rows, int cols, Set<String> set){
        //需要添加一个是否已经遍历过的情况，直接return
        String str = String.valueOf(i) + '_' + String.valueOf(j);
        //越界条件。这里面不能等于col和row的
        if (i < 0 || i >= rows || j < 0 || j >= cols || getDigitNum(i) + getDigitNum(j) > threshold || set.contains(str)){
            return;
        }
        //在没有越界的时候，放入set，开始对四个方向进行递归
        set.add(str);
        process(i + 1, j, threshold, rows, cols, set);
        process(i - 1, j, threshold, rows, cols, set);
        process(i, j + 1, threshold, rows, cols, set);
        process(i, j - 1, threshold, rows, cols, set);
    }

    public static int getDigitNum(int num){
        int res = 0;
        while (num > 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
