package Thread_study02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:20
 * @Title&Description: sleep模拟倒计时
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime() - 1000);
            if (end - 1000 * 10 > endTime.getTime()){
                break;
            }
        }
    }

    public static void test() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);  //主线程阻塞
            System.out.println(num--);
        }
    }
}
