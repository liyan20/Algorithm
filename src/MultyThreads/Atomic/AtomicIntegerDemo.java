package MultyThreads.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xianz
 * @Date: 2020/9/6 19:47
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger1 = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
//        atomicInteger.getAndAdd(1);
//        atomicInteger.incrementAndGet();
//        atomicInteger.compareAndSet(1, 2);
//        atomicInteger.get();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("one");
                atomicInteger1.getAndAdd(1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (atomicInteger1.get() != 1){

                }
                System.out.println("two");
                atomicInteger2.getAndAdd(1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (atomicInteger2.get() != 1){

                }
                System.out.println("three");
            }
        }).start();
    }


}
