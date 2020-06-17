package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/27 10:47
 * @Title: 坐标移动
 * @Description: 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * @InputDescription: 一行字符串
 * @OuputDescription: 最终坐标，以,分隔
 */
import java.util.*;
public class Test_0427_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int left = 0;
            int right = 0;
            String[] strlist = sc.nextLine().split(";");
            for(int i=0; i<strlist.length; i++){
                String order = strlist[i];
                if(isEfficient(order)){
                    int num = Integer.valueOf(order.substring(1));
                    if(order.charAt(0) == 'A'){
                        left -= num;
                    }else if(order.charAt(0) == 'D'){
                        left += num;
                    }else if(order.charAt(0) == 'W'){
                        right += num;
                    }else if(order.charAt(0) == 'S'){
                        right -= num;
                    }
                }
            }
            System.out.println(left+","+right);
        }
    }

    public static boolean isEfficient(String input){
        String index = "ADWS";
        if(input.length() == 0){
            return false;
        }
        if(!index.contains(input.substring(0, 1))){
            return false;
        }else if(input.length() == 2 && Character.isDigit(input.charAt(1))){
            return true;
        }else if(input.length() == 3 && Character.isDigit(input.charAt(1))
                && Character.isDigit(input.charAt(2))){
            return true;
        }else{
            return false;
        }
    }
}
