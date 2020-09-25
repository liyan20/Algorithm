package ThreadStudy.Thread_study01;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:21
 * @Title&Description:
 * 并发。共享资源
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Web12306 implements Runnable {
    //票数
    private int ticketNums = 99;
    @Override
    public void run() {
        while (true){
            if (ticketNums < 0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "—>" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web, "1号").start();
        new Thread(web, "2号").start();
        new Thread(web, "3号").start();
    }
}
