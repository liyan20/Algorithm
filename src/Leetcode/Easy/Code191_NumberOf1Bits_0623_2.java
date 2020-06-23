package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/6/23 16:48
 * @Title&Description: 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * @Analysis:
 * 看题解方法是和1进行与操作，如果是1说明最后一位是1，如果是0说明最后一位是0，然后把用于比较的这个1左移1位
 * 因为是无符号整数，最多是32位
 * @Summary:
 * @TimeConsuming:
 */
public class Code191_NumberOf1Bits_0623_2 {
    public int hammingWeight(int n) {
        int mask = 1;
        int res = 0;
        for (int i=0; i<32; i++){
            if ((n & mask) != 0){
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }

    public int hammingWeight2(int n){
        String str = Integer.toBinaryString(n);
        int res = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '1'){
                res += 1;
            }
        }
        return res;
    }
}
