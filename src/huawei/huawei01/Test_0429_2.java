package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/29 10:16
 * @Title:
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 */
import java.util.*;
public class Test_0429_2 {
    public static void main(String[] args) {
        String num = String.valueOf(234);
        int product = 1;
        int sum = 0;
        for(int i=0;i<num.length();i++){
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
            product *= Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        System.out.println(product-sum);
        }
}


