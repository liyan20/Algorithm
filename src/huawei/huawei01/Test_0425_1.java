package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 10:04
 * @Title: 字符串最后一个单词的长度
 * @Description: 计算字符串最后一个单词的长度，单词以空格隔开。
 */
import java.util.*;
public class Test_0425_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
            String[] strlist = str.split(" ");
            System.out.println(strlist[strlist.length - 1].length());
    }
}
