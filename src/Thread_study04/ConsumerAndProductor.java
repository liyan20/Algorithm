package Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/15 20:42
 * @Title&Description:
 * 协作模型：生产者消费者实现方式1：管程法
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class ConsumerAndProductor {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        //生产
        for (int i=1; i<100; i++){
            System.out.println("生产-->"+i+"馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i=1; i<100; i++){
            System.out.println("消费-->"+container.pop().id+"馒头");
        }
    }
}
//缓冲区
class SynContainer{
   Steamedbun[] buns = new Steamedbun[10];
   int count = 0;  //计数器
   //存储 生产
    public synchronized void push(Steamedbun bun){
        //什么时候可以生产
        //存在空间可以生产
        //没有空间只有等待
        if (count == buns.length){
            try {
                this.wait();  //线程阻塞。消费者通知生产时，解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        //存在数据了，可以唤醒对方消费了
        this.notifyAll();
    }
    //获取
    public synchronized Steamedbun pop(){
        //什么时候可以消费
        //存在数据可以消费
        //没有数据只有等待
        if (count == 0){
            try {
                this.wait();  //线程阻塞。生产者通知消费时，解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();  //存在空间了，可以唤醒对方生产了
        return bun;
    }
}
//馒头
class Steamedbun{
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }
}
