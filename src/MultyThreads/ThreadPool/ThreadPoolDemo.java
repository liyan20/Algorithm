package MultyThreads.ThreadPool;



/**
 * @Author: xianz
 * @Date: 2020/9/7 09:17
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        int j = 0;
        for (int i=0; i<10; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                }
            });
        }
    }
}
