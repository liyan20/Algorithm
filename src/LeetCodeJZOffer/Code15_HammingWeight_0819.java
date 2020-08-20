package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 14:57
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code15_HammingWeight_0819 {

    /**
     * 进行按位与操作即可，每次循环mask左移一位
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int res = 0;
        for(int i=0; i<32; i++){
            if((mask & n) != 0){  //这边很重要，不能直接判断结果是不是1，因为中间为1整个数不一定是1
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }
}
