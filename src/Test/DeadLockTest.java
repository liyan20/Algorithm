package Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xianz
 * @Date: 2020/7/20 15:40
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class DeadLockTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        new Thread(new DeadLock(1)).start();
        new Thread(new DeadLock(0)).start();
    }

    public static Object a = new Object();
    public static Object b = new Object();

    public static class DeadLock implements Runnable{
        int flag;
        public DeadLock(int flag) {
            this.flag = flag;
        }
        @Override
        public void run() {
            if (flag == 1){
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "我要a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + "我要b");
                    }
                }
            }else {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "我要b");
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + "我要a");
                    }
                }
            }
        }
    }
}
