package Thread_study03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:32
 * @Title&Description: 操作并发容器
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SynContainer {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i=0; i<10000; i++){
            new Thread(()->{
                //锁list。你要修改谁就锁谁
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
