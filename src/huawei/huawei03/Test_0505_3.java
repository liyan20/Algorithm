package huawei.huawei03;

/**
 * @Author: xianz
 * @Date: 2020/5/5 08:58
 * @Title: 学英语
 * @Description: 将数字转换成英文：如22：twenty two，123：one hundred and twenty three。
 * @Analysis: billion，million，thousand，hundred。在hundred和后面几十的时候需要加and。
 * @ThinkingSteps: 1.先从高到低，依次取出百万，千，然后搞下面的 2.注意，如果百位是0，就不加and
 * @TimeConsuming: 1h23min
 */
import java.util.*;
public class Test_0505_3 {
    public static String[] list1 = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nintenn"};
    public static String[] list2 = {"zero","zero","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long num = sc.nextLong();
            StringBuilder sb = new StringBuilder();
            Map<String,Long> map = new HashMap<>();
            map.put("million", (long)0);
            map.put("thousand", (long)0);
            map.put("hundred", (long)0);
            map.put("onlydigit", (long)0);
            map.put("ten", (long)0);
            map.put("digit", (long)0);
            if(num<0){
                System.out.println("error");
            }else{
                while(num/1000000 != 0){
                    map.put("million", num/1000000);
                    num = num % 1000000;
                }
                while(num/1000 != 0){
                    map.put("thousand", num/1000);
                    num = num % 1000;
                }

                if(map.get("million") != 0){
                    sb.append(transHun(map.get("million").intValue()) + " million ");
                }
                if(map.get("thousand") != 0){
                    sb.append(transHun(map.get("thousand").intValue()) + " thousand ");
                }
                sb.append(transHun(num));
                System.out.println(sb.toString());
            }
        }
    }

    public static String transHun(long num){
        StringBuilder sb = new StringBuilder();
        Map<String,Long> map = new HashMap<>();
        map.put("hundred", (long)0);
        map.put("onlydigit", (long)0);
        map.put("ten", (long)0);
        map.put("digit", (long)0);
        while(num/100 != 0){
            map.put("hundred", num/100);
            num = num % 100;
        }
        if(num<=19){
            map.put("onlydigit", num);
        }else{
            map.put("ten", num/10);
            map.put("digit", num % 10);
        }

        if(map.get("hundred") != 0){
            sb.append(list1[map.get("hundred").intValue()] + " hundred ");
            sb.append("and ");
        }
        if(map.get("onlydigit") != 0){
            sb.append(list1[map.get("onlydigit").intValue()]);
        }
        if(map.get("ten") != 0){
            sb.append(list2[map.get("ten").intValue()]);
        }
        if(map.get("digit") != 0){
            sb.append(" "+ list1[map.get("digit").intValue()]);
        }
        return sb.toString();
    }
}
