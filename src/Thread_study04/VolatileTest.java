package Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 11:30
 * @Title&Description:
 * volatile用于保证数据同步，就是可见性
 * 不保证原子性。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class VolatileTest {
    public static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
        }).start();
        Thread.sleep(1000);
        num = 1;
    }
}
