package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 14:02
 * @Title: 质数因子
 * @Description: 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * @InputDescription: 输入一个long型整数 180
 * @OuputDescription: 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。 2 2 3 3 5
 */
import java.util.*;
public class Test_0425_5 {
    public static void main(String[] args) {
        Test_0425_5 test = new Test_0425_5();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long num = sc.nextInt();
            System.out.println(test.getResult(num));
        }
    }
    public String getResult(long ulDataInput) {
        long num = ulDataInput;
        StringBuilder sb = new StringBuilder();
        if (isPrime(ulDataInput)) {
            sb.append(ulDataInput + " ");
        } else {
            for (int i = 2; i < num; i++) {
                while (ulDataInput % i == 0) {
                    ulDataInput /= i;
                    sb.append(i);
                    sb.append(" ");
                }
                if (ulDataInput == 1) {
                    break;
                }
            }
        }
        return sb.toString();
    }
    public boolean isPrime(long num) {
        if (num == 2) {
            return true;
        }else{
            for (int i = 2; i < Math.sqrt(num)+1; i++){
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
