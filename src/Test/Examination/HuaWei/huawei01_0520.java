package Test.Examination.HuaWei;

/**
 * @Author: xianz
 * @Date: 2020/5/20 19:01
 * @Title&Description: 链表分组
 * 给你一个string作为分组条件，node.name就是看看是不是等于这个
 * 边界条件：输入不满足要求，输出0
 * @Analysis: 1.输入的是int，然后是字符串，中间好像是逗号啊。用两个arraylist装，第一个装第一个输入的类别，第二个装第二个的
 * 搞错了，那个符号是分组的符号，有几个就分几组
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class huawei01_0520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<String> listAll = new ArrayList<>();
            String splitter = "";
            splitter = sc.nextLine();
            while (sc.hasNext()){
                String temp = sc.nextLine();
                if(temp.split(",").length==2){
                    listAll.add(temp);
                }
            }
            while (listAll.get(listAll.size()-1).equals("")){
                listAll.remove(listAll.size()-1);
            }
            int num = 1;
            while (listAll.get(0).split(",")[1].equals(splitter)){
                listAll.remove(0);
            }
            while (listAll.get(listAll.size()-1).split(",")[1].equals(splitter)){
                listAll.remove(listAll.size()-1);
            }

            if(listAll.size() == 0){
                System.out.println(1);
            }else {
                for(int i=0;i<listAll.size();i++){
                    String temp = listAll.get(i);
                    if(temp.split(",")[1].equals(splitter)){
                        num++;
                    }
                }
                System.out.println(num);
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<listAll.size();i++){
                    String temp = listAll.get(i);
                    if(!temp.split(",")[1].equals(splitter)){
                        sb.append(temp+"|");
                    }
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        System.out.println(sb.toString());
                        sb = sb.delete(0, sb.length());
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
            }
        }
    }
}
