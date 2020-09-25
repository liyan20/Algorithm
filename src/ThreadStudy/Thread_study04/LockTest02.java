package ThreadStudy.Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 16:54
 * @Title&Description:
 * 不可重入锁：锁不可以延续使用
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
//        doSomething();
        lock.unlock();
    }
    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();

        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
        lockTest02.doSomething();
    }
}

class Lock{
    //是否占用
    private boolean isLocked = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            wait();
        }
        isLocked = true;
    }
    //释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
