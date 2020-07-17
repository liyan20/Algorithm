package Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 15:10
 * @Title&Description:
 * InheritableThreadLocal继承上下文环境，拷贝一份给子线程
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class ThreadLocalTest04 {
    //更改初始值
    public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }).start();
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
