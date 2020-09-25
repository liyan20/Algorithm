package MultyThreads.Exercises;

/**
 * @Author: xianz
 * @Date: 2020/9/13 20:22
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */



/**
 * 实现两个线程交替打印奇数和偶数
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Code01_PrintOddAndEven {

    //这边需要是static修饰，因为下面有匿名内部类
    public static int i = 1;

    public static void main(String[] args) {
        int n = 100;  //打印的总数

        //下面的Lock和两个Condition用来处理奇数和偶数线程的阻塞问题
        Lock lock = new ReentrantLock();
        Condition oddCondition = lock.newCondition();
        Condition evenCondition = lock.newCondition();

        //负责打印奇数的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i <= n){
                        System.out.println(Thread.currentThread().getName() + ": " + i++);
                        evenCondition.signal();  //唤醒偶数线程
                        oddCondition.await();  //当前奇数线程阻塞
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        //负责打印偶数的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i <= n){
                        System.out.println(Thread.currentThread().getName() + ": "  + i++);
                        oddCondition.signal();  //唤醒奇数线程
                        evenCondition.await();  //当前偶数线程阻塞
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}
