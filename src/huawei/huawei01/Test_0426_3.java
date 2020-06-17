package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 10:54
 * @Title: 求int型数据在内存中存储时1的个数
 * @Description: 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * @InputDescription:  输入一个整数（int类型） 5
 * @OuputDescription:  这个数转换成2进制后，输出1的个数 2
 */
import java.util.*;
public class Test_0426_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num0 = sc.nextInt();
            String num1 = Integer.toBinaryString(num0);
            int result = 0;
            for(int i=0; i<num1.length(); i++){
                if(num1.charAt(i) == '1'){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
