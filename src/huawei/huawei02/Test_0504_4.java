package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/4 14:11
 * @Title:  整数与IP地址间的转换
 * @Description:
 * @Analysis: 1.ip地址的4个数字分别转化为8为2进制，最前面补0，然后给合起来再转10进制得到数字
 * 2.数字是转32位2进制，最前面补0，然后分成4个8位2进制，再转10进制加上"."
 * @ThinkingSteps: 10.0.3.193 —— 167969729
 * 小心数组越界的问题！！！
 * @TimeConsuming: 48min
 */
import java.util.*;
public class Test_0504_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strIp = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String str){
        String[] strlist = str.split("\\.");
        StringBuilder sbAll = new StringBuilder();
        for(int i=0;i<strlist.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toBinaryString(Long.valueOf(strlist[i])));
            while(sb.length()<8){
                sb.insert(0, 0);
            }
            sbAll.append(sb);
        }
        return Long.valueOf(sbAll.toString(), 2);
    }

    public static String numToIp(long n){
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        sb.append(Long.toBinaryString(n));
        while(sb.length()<32){
            sb.insert(0, 0);
        }
        for(int i=0;i<4;i++){
            String temp = sb.substring(i*8, i*8+8);
            numSb.append(Long.valueOf(temp, 2));
            numSb.append(".");
        }
        numSb.deleteCharAt(numSb.length()-1);
        return numSb.toString();
    }
}
