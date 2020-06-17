package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/5 06:49
 * @Title: 求小球落地5次后所经历的路程和第5次反弹的高度
 * @Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test_0505_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double heightIni = sc.nextDouble();
            double heightAll = heightIni;
            double heightLast = 0.;
            for(int i=0;i<4;i++){
                heightLast = heightIni / Math.pow(2, i);
                heightAll += heightLast;
            }
            heightLast /= 4;
            System.out.println(heightAll);
            System.out.println(heightLast);
        }
    }
}
