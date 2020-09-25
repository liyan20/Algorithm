package ThreadStudy.Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:32
 * @Title&Description: 操作容器 线程不安全
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SynBlockTest02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i=0; i<10000; i++){
            new Thread(()->{
                //锁list。你要修改谁就锁谁
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
