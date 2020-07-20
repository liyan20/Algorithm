package Leetcode.Coding;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/20 17:10
 * @Title&Description: 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * @Analysis:
 * 这个是一个排序的问题。看题解是要分析每个数的拼起来之后大小的关系来决定怎么排序。
 * Arrays.sort里面如果使用比较器的话必须是封装类才行，所以最好把int数组换成Integer的
 * @Summary:
 * @TimeConsuming:
 */
public class JZCode45_SortArrToMinNumber_0720_1 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,0,0,0,0};
        System.out.println(minNumber(nums));
    }
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length < 1){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = o1 * (int)(Math.pow(10, getDigitNum(o2))) + o2;
                int num2 = o2 * (int)(Math.pow(10, getDigitNum(o1))) + o1;
                if (o1 == 0 || o2 == 0){
                    return o1 - o2;
                }else {
                    return num1 - num2;
                }
            }
        });
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                long num1 = Long.valueOf(String.valueOf(o1) + String.valueOf(o2));
                long num2 = Long.valueOf(String.valueOf(o2) + String.valueOf(o1));
                return (int)(num1 - num2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static int getDigitNum(int num){
        int res = 0;
        while (num > 0){
            res++;
            num /= 10;
        }
        return res;
    }
}
