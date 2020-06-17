package Leetcode_EasyAlgorithm.String;

/**
 * @Author: xianz
 * @Date: 2020/5/7 06:57
 * @Title: 整数反转
 * @Description:
 * @Analysis:
 * 方法1.用StringBuilder，放进去再反转
 * 方法2.用数学方法，反转就是把个位数当成最高位，具体就是对每一个个位数，乘10。
 * 比如123，个位数是3，给乘上10，然后下面是2，就是123/10的个位数，对30要加上下一位的个位数，就是3*10+2，
 * 然后就是32*10+1，用long保存防止溢出
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question02_0507_1 {
    public static void main(String[] args) {
        int a = -123;
        System.out.println(reverse2(a));
    }

//    这是用的容器的方法
    public static int reverse1(int x) {
        StringBuilder sb = new StringBuilder(x+"");
        if(x<0){
            sb.deleteCharAt(0);
        }
        sb.reverse();
        if(x<0){
            sb.insert(0, "-");
        }
        long out = Long.valueOf(sb.toString());
        if(out >Math.pow(2, 31) || out<=-Math.pow(2, 31)){
            return 0;
        }
        return (int)out;
    }

//    这是直接用数学方法
    public static int reverse2(int x){
        int x2 = x> 0 ? x : -x;
        long out = 0;
        while(x2>0){
            int temp = x2%10;
            out = out*10 +temp;
            x2 /= 10;
        }
        if(x>0 && out >Math.pow(2, 31)){
            return 0;
        }else if(x<0 && out >=Math.pow(2, 31)){
            return 0;
        }
        return x>0 ? (int)out : -(int)out;
    }
}
