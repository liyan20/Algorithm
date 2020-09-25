package Collections.t2;


import java.util.PriorityQueue;


/**
 * @Author: xianz
 * @Date: 2020/9/5 15:13
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Random;
public class BlockingQueueTests2 {

    public static void main(String[] args) {
        SynBlockingQueue queue = new SynBlockingQueue(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

//缓冲区
class SynBlockingQueue{
    private int[] array;  //内部的数组，用于阻塞队列的容器

    public SynBlockingQueue(int cap){
        this.array = new int[cap];
    }

    private int count = 0;  //计数器，用于判断内部数组是否满了

    //存储的方法
    public synchronized void put(int num){
        //如果空间已经满了，就等待。直到被其他线程唤醒
        try {
            while (count == array.length){
                this.wait();  //线程阻塞。消费者通知生产时，解除阻塞
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        array[count] = num;  //存放数据
        count++;  //增加容量计数
        System.out.println(Thread.currentThread().getName() + "生产: " + count);
        this.notifyAll();  //存在数据了，可以唤醒对方消费了
    }

    //获取的方法
    public synchronized void take(){
        //只有存在数据才可以消费，没有数据即计数器是0的话只能等待，直到被其他线程唤醒
        try {
            while (count == 0){
                this.wait();  //线程阻塞。生产者通知消费时，解除阻塞
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count--;
        System.out.println(Thread.currentThread().getName() + "消费: " + count);
        this.notifyAll();  //存在空间了，可以唤醒对方生产了
    }
}

//生产者
class Producer implements Runnable{

    SynBlockingQueue queue;

    public Producer(SynBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<100; i++){
                Thread.sleep(20);
                queue.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者
class Consumer implements Runnable{

    SynBlockingQueue queue;

    public Consumer(SynBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            //只要有数据就一直消费，写成while死循环
            while (true){
                //随机睡眠0-1000ms间的数代表消费的时间间隔，说明消费者的消费能力没有生产者那么快
                Thread.sleep(new Random().nextInt(1000));
                queue.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}