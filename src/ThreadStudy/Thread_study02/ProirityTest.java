package ThreadStudy.Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 10:10
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class ProirityTest {
    public static class MyProirity implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        MyProirity mp = new MyProirity();
        Thread t1 = new Thread(mp);
        Thread t2 = new Thread(mp);
        Thread t3 = new Thread(mp);
        Thread t4 = new Thread(mp);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getPriority());
    }
}
