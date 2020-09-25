package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/9/23 11:19
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code_MySort_0923 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2, 0.000001));
    }

    /**
     * 二分法求解平方根
     * @param num 要求平方根的整数数字
     * @param range  //要求的范围
     * @return
     */
    public static double mySqrt(int num, double range){
        double low = 0;
        double high = num;
        double mid = (low + high) / 2.0;  //先求出mid，用于下面的循环判断

        //大循环条件。num和mid的差值大于要求的范围
        while (Math.abs(num - mid * mid) > range){
            if (mid * mid > num){  //如果大于num，那么就在前面考虑
                high = mid;
            }else if (mid * mid < num){  //如果小于num，那么就在后面考虑
                low = mid;
            }
            mid = (low + high) / 2.0;  //这边是为了下一次的调用
        }
        return mid;  //退出循环说明差值小于要求的范围了。
    }

    //三次方根。和平方根完全一样
    public static double mySqrt3(int num, double range){
        double low = 0;
        double high = num;
        double mid = (low + high) / 2.0;  //先求出mid，用于下面的循环判断

        //大循环条件。num和mid的差值大于要求的范围
        while (Math.abs(num - mid * mid * mid) > range){
            if (mid * mid * mid > num){  //如果大于num，那么就在前面考虑
                high = mid;
            }else if (mid * mid * mid < num){  //如果小于num，那么就在后面考虑
                low = mid;
            }
            mid = (low + high) / 2.0;  //这边是为了下一次的调用
        }
        return mid;  //退出循环说明差值小于要求的范围了。
    }

}
