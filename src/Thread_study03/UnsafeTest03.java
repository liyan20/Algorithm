package Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:32
 * @Title&Description: 操作容器 线程不安全
 * 改数据时候要注意线程安全。只是读取不需要
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<10000; i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
