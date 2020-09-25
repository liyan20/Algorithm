package Collections.t2;




/**
 * @Author: xianz
 * @Date: 2020/9/6 16:29
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BlockingQueueDemo{

    /** 底层负责存放元素的数组*/
    private Integer[] items;

    /** 下一个取出操作的index */
    int takeIndex;

    /** 下一个放入操作的index */
    int putIndex;

    /** 队列中元素的个数 */
    int count;

    //主要的保证线程安全的锁
    private final Lock lock;

    /** 用于等待take的Condition */
    private final Condition notEmpty;

    /** 用于等待put的Condition */
    private final Condition notFull;

    public BlockingQueueDemo(int capacity) {
        this.items = new Integer[capacity];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull =  lock.newCondition();
    }

    /**
     * put放入方法。
     * @param data 存入的数据
     * @throws InterruptedException
     */
    public void put(int data) throws InterruptedException {
        lock.lock();
        try {
            //这边为什么要用while呢，是因为可能多个线程会被signal唤醒。
            //如果这个线程被唤醒之后还没来得及操作其他线程也插入导致又满了，就需要继续阻塞等待。
            //所以需要用while而不是if
            while (count == items.length){
                //当数组满的时候，要将用于put的Condition等待。
                // 字面意思就是没有满的Condition阻塞，其实就是满了的意思
                notFull.await();
            }
            items[putIndex] = data;

            /**
             * 终于知道这边为什么是都是++并且要变成0了。
             * 因为这个是一个队列，先进先出，但是底层又是一个数组。
             * 所以加入元素的位置和弹出元素的位置是同步++的，比如一开始都是0开始
             * 然后在0加了一个元素，putIndex++之后变成1，然后takeIndex是0，这时候0位置已经有东西了
             * 如果是调用take方法，就把然后takeIndex位置也就是0位置的给取出来，takeIndex++。
             * 这样保证在使用数组的情况下实现队列的效果，都++。并且这种方法如果前面比如4个都被添加并取出，
             * 下面的putIndex是在第五个位置添加，takeIndex也是从第五个开始，不用管前面的。实现了先进先出的队列效果。
             * 之后如果是putIndex或者是takeIndex到了数组长度尽头了，将他们置为0就行
             * 再次从0开始添加，实现队列的先进先出效果。
             */
            if (++putIndex == items.length){
                putIndex = 0;
            }
            count++;
            //走到这边说明已经生产东西了，将用于take的Condition唤醒
            // 字面意思是 '没有空' 的Condition唤醒，代表目前有东西了。
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 用于取出的方法。
     * @return 返回取出的那个元素
     * @throws InterruptedException
     */
    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            int data = items[takeIndex];
            items[takeIndex] = 0;
            if (++takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            notFull.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

}
