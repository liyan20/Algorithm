package MultyThreads.ProAndCon_BloQue;



/**
 * @Author: xianz
 * @Date: 2020/9/5 15:13
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProAndConDemo_BlockingQueue {

    public static void main(String[] args) {
        //生产者消费者共用一个阻塞队列。ArrayBlockingQueue底层是数组实现，要传入一个数组长度。
        //因为设置了10的容量，所以生产者在阻塞队列里面有了10个东西的时候就不再生产
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();  //设置三个消费者进行消费
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

}

//生产者类
class Producer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue){  //构造方法里面把阻塞队列导入进来
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            //最多生产100个数，每次生产完一个放进队列，打印一下就完了。
            for (int i=0; i<100; i++){
                Thread.sleep(20);  //停顿固定的20ms，模拟实际生产的情况
                queue.put(i);  // i是生产的数据，将数据存入阻塞队列

                //这边的输出其实是有问题的，因为是额外调用了size，会出现size的值并发错误的情况。
                //不建议使用这种方法表示生产者消费者
                System.out.println(Thread.currentThread().getName() + "生产: " + queue.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//消费者类
class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
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
                System.out.println(Thread.currentThread().getName() + "消费: " + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}