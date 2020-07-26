package Thread_study04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xianz
 * @Date: 2020/7/21 11:04
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class RentrantLockTest {
    public static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }).start();
    }

    public static void test(){
        for (int i=0; i<3; i++){
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            lock.unlock();
        }
    }
}
