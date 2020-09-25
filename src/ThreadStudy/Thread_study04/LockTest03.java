package ThreadStudy.Thread_study04;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xianz
 * @Date: 2020/7/16 16:54
 * @Title&Description:
 * 不可重入锁：锁不可以延续使用
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class LockTest03 {
    ReentrantLock lock = new ReentrantLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 lockTest02 = new LockTest03();
        lockTest02.a();
    }
}

class ReLock{
    //是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null;  //存储线程
    private  int holdCount = 0;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != Thread.currentThread()){
            wait();
        }
        //就是加个判断，进来的这个线程是不是我们已经锁定的线程，如果是那就不要等了，直接用
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }

    public int getHoldCount() {
        return holdCount;
    }

    //释放锁
    public synchronized void unlock(){
        if (Thread.currentThread() == lockedBy){
            holdCount--;
            if (holdCount == 0){
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }
}
