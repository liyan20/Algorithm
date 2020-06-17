package huawei.huawei01;
import java.util.*;
/**
 * @Author: xianz
 * @Date: 2020/4/24 17:39
 * @Description:明明的随机数
 */
public class Test_0424_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for(int i=0; i<n; i++){
                set.add(sc.nextInt());
            }
            for(Iterator<Integer> iter = set.iterator(); iter.hasNext();){
                System.out.println(iter.next());
            }
        }
    }
}
