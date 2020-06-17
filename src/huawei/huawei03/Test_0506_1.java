package huawei.huawei03;

/**
 * @Author: xianz
 * @Date: 2020/5/6 10:53
 * @Title: 华为机试1
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test_0506_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            List<Integer> list = new ArrayList<>();
            String str0 = sc.nextLine();
            int n = Integer.valueOf(str0.split(" ")[0]);
            int m = Integer.valueOf(str0.split(" ")[1]);
            String str = sc.nextLine();
            String[] strlist = str.split(" ");
            for(int i=0;i<strlist.length;i++){
                list.add(Integer.valueOf(strlist[i]));
            }
            for(int i=0;i<m;i++){
                String[] orderlist = sc.nextLine().split(" ");
                String order = orderlist[0];
                int num1 = Integer.valueOf(orderlist[1]);
                int num2 = Integer.valueOf(orderlist[2]);
                int index1 = Math.min(Integer.valueOf(orderlist[1]), Integer.valueOf(orderlist[2]));
                int index2 = Math.max(Integer.valueOf(orderlist[1]), Integer.valueOf(orderlist[2]));
                if(order.equals("Q")){
                    if(index1 == index2){
                        System.out.println(list.get(index1-1));
                    }else{
                        List<Integer> tempList = new ArrayList<>();
                        for(int j=index1-1;j<index2;j++){
                            tempList.add(list.get(j));
                        }
                        Collections.sort(tempList);
                        System.out.println(tempList.get(tempList.size()-1));
                    }
                }else if(order.equals("U")){
                    list.set(num1-1,num2);
                }
            }
        }
    }
}

