package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 11:06
 * @Title: 提取不重复的整数
 * @Description: 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * @InputDescription: 输入一个int型整数 9876673
 * @OuputDescription: 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数 37689
 */
import java.util.*;
public class Test_0426_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Set<String> set = new LinkedHashSet <>();
            String str = sc.nextLine();
            for(int i=str.length()-1; i>=0; i--){
                set.add(String.valueOf(str.charAt(i)));
            }
            for(Iterator<String> iter = set.iterator(); iter.hasNext();){
                System.out.print(iter.next());
            }
        }
    }
}
