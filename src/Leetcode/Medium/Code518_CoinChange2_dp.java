package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/28 23:46
 * @Title&Description:
 * 可变参数是index当前位置，还有剩余的钱数rest
 * 先把表建立起来。但是问题来了，这个递归函数本身是需要枚举的，就是递归函数里面有一个for循环的
 * 所以填表都是从小的填到大的或者大的到小的的顺序来，所以直接用枚举在动态规划中是失效的。
 * 在本题中，我们发现每个位置是需要下面的位置然后加上下面左边的位置再加左边，每个地方间隔是当前的arr[index]
 * 分别代表的是用0张当前位置的金额，还有一张，两张等等
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code518_CoinChange2_dp {
}
