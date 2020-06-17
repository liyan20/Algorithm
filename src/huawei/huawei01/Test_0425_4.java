package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 13:35
 * @Title: 进制转换
 * @Description: 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * @InputDescription: 输入一个十六进制的数值字符串。 0xA
 * @OuputDescription: 输出该数值的十进制字符串。 10
 */
import java.util.*;
public class Test_0425_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(i+"",i+"");
        }
        map.put("A", 10+"");
        map.put("B", 11+"");
        map.put("C", 12+"");
        map.put("D", 13+"");
        map.put("E", 14+"");
        map.put("F", 15+"");

        while(sc.hasNext()){
            int num = 0;
            String str = sc.nextLine().substring(2);
            for(int i=str.length()-1; i>=0; i--){
                String tempstr = map.get(str.charAt(i)+"");
                int tempint = Integer.valueOf(tempstr);
                num += tempint * Math.pow(16, str.length()-1-i);
            }
            System.out.println(num+"");
        }
    }
}
