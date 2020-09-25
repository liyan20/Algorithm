package Collections.serialize.aerg;

/**
 * @Author: xianz
 * @Date: 2020/9/6 11:04
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProAndCon {




    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        int length = 10;
        new Thread(new Producer(queue, length)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable{
    private List<Integer> queue;
    private int length;

    public Producer(List<Integer> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        synchronized (queue){
            try {
                while(queue.size() >= length){
                    queue.wait();
                }
                Thread.sleep(20);
                queue.add(1);
                System.out.println(Thread.currentThread().getName() + "生产: " + queue.size());
                queue.notifyAll();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    private List<Integer> queue;

    public Consumer(List<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue){
            try {
                while (queue.isEmpty()){
                    System.out.println("Queue is Empty");
                    queue.wait();
                }
                Thread.sleep(new Random().nextInt(500));
                queue.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费: " + queue.size());
                queue.notifyAll();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

