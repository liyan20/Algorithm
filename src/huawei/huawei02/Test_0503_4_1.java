package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 14:31
 * @Title: 统计每个月兔子的总数
 * @Description:
 * @Analysis: 1.每个月的兔子总数 = 上个月的总数+这个月能生的兔子数量 2.这个月能生的要至少三月大，就是两个月前的兔子
 * @ThinkingSteps: 就是斐波那契数列，这次试试迭代和动态规划法
 * @TimeConsuming: 45min
 */
import java.util.*;
public class Test_0503_4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(fabIter(num));
        }
    }
    public static int fabIter(int n){
        if(n == 1 || n ==2){
            return 1;
        }else{
            return fabIter(n-1) + fabIter(n-2);
        }
    }
}
