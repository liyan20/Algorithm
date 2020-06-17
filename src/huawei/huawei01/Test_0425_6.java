package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 16:05
 * @Title: 取近似值
 * @Description: 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * @InputDescription: 输入一个正浮点数值 5.5
 * @OuputDescription: 输出该数值的近似整数值 6
 */
import java.util.*;
public class Test_0425_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double d = sc.nextDouble();
            if(d - (int)d < 0.5){
                System.out.println((int)d);
            }else{
                System.out.println((int)d +1);
            }
        }
    }
}
