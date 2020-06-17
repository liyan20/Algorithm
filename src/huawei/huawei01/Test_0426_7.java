package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/26 18:43
 * @Title:  字串的连接最长路径查找
 * @Description: 给定n个字符串，请对n个字符串按照字典序排列。
 * @InputDescription: 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * @OuputDescription: 数据输出n行，输出结果为按照字典序排列的字符串。
 */
import java.util.*;
public class Test_0426_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String[] strlist = new String[n];
            for(int i=0;i<n;i++){
                strlist[i] = sc.nextLine();
            }
            Arrays.sort(strlist);
            for(int i=0;i<n;i++){
                System.out.println(strlist[i]);;
            }
        }
    }
}
