package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/4 07:00
 * @Title: 汽水瓶
 * @Description:
 * @Analysis: 1.3个换一个，所以换完一轮，得到的汽水数量是n/3，手里目前的汽水瓶是n/3 + n%3，就是换的那些加上之前没换上的
 * 然后如果是两个还可以喝一个汽水，手里面就没有瓶子了，如果还剩1个，那就没办法了。之前被这个2问老板借一个然后换回去唬住了，其实不难。
 * @ThinkingSteps:
 * @TimeConsuming: 20min
 */
import java.util.*;
public class Test_0504_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num != 0){
                System.out.println(Solution(num));
            }
        }
    }
    public static int Solution(int n){
        int count = 0;
        int numLeft = 0;
        while(n>=3){
            int waterBottle = n/3;
            count += waterBottle;
            numLeft = n%3;
            n = waterBottle + numLeft;
        }
        if(n == 2){
            count ++;
        }
        return count;
    }
}
