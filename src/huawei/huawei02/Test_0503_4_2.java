package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 15:05
 * @Title: 统计每个月兔子的总数
 * @Description: 动态规划查表法。但是数值可能会溢出。
 * @Analysis: 05.15修正，这才是真正的自顶而下法
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test_0503_4_2 {
    public static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            map.put(1, 1);
            map.put(2, 1);
            System.out.println(fabDP(num));
        }
    }
    public static int fabDP(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            map.put(n,fabDP(n-1)+fabDP(n-2));    //这一步是两个操作，第一个是递归计算数值，第二个是放入map里面
            return fabDP(n);
            //这里面的写法是直接返回这个函数，因为n在上一步已经求解了，所以是可以返回去调用第一个if语句，从map里面得到结果
            //或者是在上面int value = fabDP(n-1)+fabDP(n-2); return value;也是可以的，一样效果
            //第二种写法
//            int value = fabDP(n-1)+fabDP(n-2);
//            map.put(n,value);
//            return value;
        }
    }
}
