package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 06:49
 * @Title: 字符串合并处理
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis: .合并 2.按照奇偶位排序 3.对16进制进行转换,就是16进制的0-9，a-f转化为2进制，然后4位2进制倒序，再给转回16进制
 *  * 4.异常操作（数组越界）
 * @TimeConsuming: 1h20min
 */
import java.util.*;
public class Test_0503_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next()+sc.next();
            sc.nextLine();
//            String str = str0.split(" ")[0] + str0.split(" ")[1];
            if(!str.isEmpty()){
                String result = sort(str);
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<result.length();i++){
                    sb.append(transform(result.charAt(i)));
                }
                System.out.println(sb.toString());
            }
        }
    }

    public static String sort(String str){
        List<Character> oddlist = new ArrayList<>();
        List<Character> evenlist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if((i+1)%2 == 1){
                oddlist.add(str.charAt(i));
            }else{
                evenlist.add(str.charAt(i));
            }
        }
        Collections.sort(oddlist);
        Collections.sort(evenlist);
        for(int i=0;i<Math.min(oddlist.size(),evenlist.size());i++){
            sb.append(oddlist.get(i));
            sb.append(evenlist.get(i));
        }
        if(oddlist.size()>evenlist.size()){
            sb.append(oddlist.get(oddlist.size()-1));
        }else if(oddlist.size()<evenlist.size()){
            sb.append(evenlist.get(evenlist.size()-1));
        }
        return sb.toString();
    }

    public static String transform(char cha){
        int temp = 0;
        if(Character.isDigit(cha)){
            temp = Integer.valueOf(""+cha,16);
        }else if(Character.toLowerCase(cha)>='a' && Character.toLowerCase(cha)<='f'){
            temp = Integer.valueOf(""+cha,16);
        }else{
            return String.valueOf(cha);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(temp));
        while(sb.length() != 4){
            sb.insert(0, "0");
        }
        sb.reverse();
        return Integer.toHexString(Integer.valueOf(sb.toString(),2)).toUpperCase();
    }
}
