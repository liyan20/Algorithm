package ThreadStudy.Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:27
 * @Title&Description:
 * 礼让线程
 * yieldz让出CPU调度，直接进入就绪状态
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my, "a").start();
        new Thread(my, "b").start();
    }

    static class MyYield implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--start");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "--end");
        }
    }
}


