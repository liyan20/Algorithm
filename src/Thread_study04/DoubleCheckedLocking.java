package Thread_study04;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/7/16 11:35
 * @Title&Description:
 * 单例模式：多线程环境下，对外存在一个对象
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class DoubleCheckedLocking {
    //指令重排序，要加volatile
    private static volatile DoubleCheckedLocking instance;
    private DoubleCheckedLocking(){
    }
    public static DoubleCheckedLocking getInstance(long time){
        //再次检测
        if (null != instance){
            return instance;
        }
        synchronized (DoubleCheckedLocking.class){
            if (null == instance){
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }

    //这个就会并发出错，得到两个对象
    public static DoubleCheckedLocking getInstance1(long time){
//        //再次检测
//        if (null != instance){
//            return instance;
//        }
//        synchronized (DoubleCheckedLocking.class){
        if (null == instance){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new DoubleCheckedLocking();
        }
//        }
        return instance;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();



        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance1(500));
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance1(1000));
    }
}
