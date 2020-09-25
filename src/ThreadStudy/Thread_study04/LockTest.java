package ThreadStudy.Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 16:54
 * @Title&Description:
 * 可重入锁：锁可以延续使用
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class LockTest {
    public void test(){
        synchronized (this){
            while (true){
                synchronized (this){
                    System.out.println("ReentrantLock");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest().test();
    }
}
