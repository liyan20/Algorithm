package Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:38
 * @Title&Description:
 * join：合并线程，插队线程
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class BlockJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("lambda" + i);
            }
        });
        t.start();
        for (int i=0; i<100; i++){
            if (i == 20){
                t.join();  //插队。main被阻塞.等到t线程运行完，才接着进行main线程。在哪个线程体内部，谁就被阻塞
            }
            System.out.println("main" + i);
        }
    }
}
