package Collections;

import java.util.concurrent.*;

/**
 * @Author: xianz
 * @Date: 2020/8/25 08:34
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());



    }


}
