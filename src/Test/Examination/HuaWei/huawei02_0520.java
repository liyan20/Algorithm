package Test.Examination.HuaWei;

/**
 * @Author: xianz
 * @Date: 2020/5/20 19:38
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class huawei02_0520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<String> listAll = new ArrayList<>();
            String splitter = sc.nextLine();
            while (sc.hasNextInt()){
                int id = sc.nextInt();
                String name = sc.next();
                sc.nextLine();
                listAll.add(id+"a");
            }
            System.out.println(listAll);
            String a = "a";

        }
    }
}
