package Thread_study01;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:00
 * @Title&Description: 创建线程
 * 继承Thread类，重写run方法
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class StartThread extends Thread {
    //线程的入口点
    @Override
    public void run() {
        for (int i=0; i<20;i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        //创建子类对象，调用start
        StartThread st = new StartThread();
        st.start(); //不保证立即运行，由cpu自己调用
        for (int i=0; i<20;i++){
            System.out.println("一边coding");
        }
    }
}
