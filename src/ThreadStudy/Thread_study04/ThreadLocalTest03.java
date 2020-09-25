package ThreadStudy.Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 15:10
 * @Title&Description:
 * 分析上下文环境
 * 构造器：哪里调用，属于谁
 * get,set,initialValue
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class ThreadLocalTest03 {
    //更改初始值
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        public MyRun(){
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "还剩下-->" + threadLocal.get());
        }
    }
}
