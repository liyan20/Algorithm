package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/1 16:41
 * @Title: 图片整理
 * @Description: Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。
 * @InputDescription: Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * @OuputDescription: Lily的所有图片按照从小到大的顺序输出 Ihave1nose2hands10fingers
 * @TimeConsuming: 0112Iaadeeefghhinnnorsssv
 */
import java.util.*;
public class Test_0501_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] charlist = str.toCharArray();
            Arrays.sort(charlist);
            System.out.println(charlist);
        }
    }
}
