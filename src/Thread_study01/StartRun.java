package Thread_study01;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:16
 * @Title&Description:
 * 继承Runnable接口，实现run方法，使用Thread对象，调用start
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class StartRun implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<20;i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        StartRun sr = new StartRun();
        Thread t = new Thread(sr);
        t.start();

        //匿名：一个对象只使用一次，不需要声明引用
        new Thread(new StartRun()).start();
        for (int i=0; i<20;i++){
            System.out.println("一边coding");
        }
    }
}
