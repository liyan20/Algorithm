package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/5 07:10
 * @Title: 判断两个IP是否属于同一子网
 * @Description:
 * @Analysis: 1.子网掩码是只有一个，ip地址两个。四个.分隔的数字，换成8位2进制，然后ip地址分别和子网掩码进行按位与运算，
 * 之后再换成10进制，如果换成之后的相同，那就是同一个子网，返回1，否则返回0
 * @ThinkingSteps:
 * @TimeConsuming: 50min
 */
import java.util.*;
public class Test_0505_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String mask = sc.next();
            String ip1 = sc.next();
            String ip2 = sc.next();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if(!judge(mask) || !judge(ip1) || !judge(ip2)){
                System.out.println(1);
            }else{
                String[] maskList = mask.split("\\.");
                String[] ipList1 = ip1.split("\\.");
                String[] ipList2 = ip2.split("\\.");
                for(int i=0;i<maskList.length;i++){
                    sb1.append(Integer.valueOf(maskList[i]) & Integer.valueOf(ipList1[i]));
                    sb2.append(Integer.valueOf(maskList[i]) & Integer.valueOf(ipList2[i]));
                    sb1.append(".");
                    sb2.append(".");
                }
                sb1.deleteCharAt(sb1.length()-1);
                sb2.deleteCharAt(sb2.length()-1);
                if(sb1.equals(sb2.toString())){
                    System.out.println(0);
                }else{
                    System.out.println(2);
                }
            }
        }
    }

    public static boolean judge(String str){
        String[] strList = str.split("\\.");
        int flag = 0;
        for(int i=0;i<strList.length;i++){
            if(Integer.valueOf(strList[i]) < 0 || Integer.valueOf(strList[i])>255){
                flag = 0;
                break;
            }else{
                flag = 1;
            }
        }
        if(flag == 0){
            return false;
        }else{
            return true;
        }
    }
}
