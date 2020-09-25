package ThreadStudy.Thread_study01;

import java.util.concurrent.*;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:45
 * @Title&Description:
 * 继承Callable接口，实现call方法
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class StartCall implements Callable {
    @Override
    public Boolean call() throws Exception {
        for (int i=0; i<100; i++){
            System.out.println(i);
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StartCall sc1 = new StartCall();
        ExecutorService ser = Executors.newFixedThreadPool(1);
        Future<Boolean> result = ser.submit(sc1);
        boolean r1 = result.get();
        ser.shutdownNow();
    }
}
