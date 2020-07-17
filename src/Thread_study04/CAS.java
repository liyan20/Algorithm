package Thread_study04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xianz
 * @Date: 2020/7/16 20:08
 * @Title&Description:
 * CAS 比较并交换。是乐观锁的一种实现。
 * 比较，如果没动过，交换，如果动过，不管
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            new Thread(()->{
                //模拟网络延迟
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"抢了一件商品");
                System.out.println("-->还剩" + left);
            }).start();
        }
    }
}
