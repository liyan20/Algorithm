package Thread_study02;

import Thread_study01.Web12306;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:15
 * @Title&Description:
 * sleep模拟网络延时
 * sleep之后进入阻塞，时间到了进入就绪状态
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

public class BlockedSleep01 implements Runnable {
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
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web, "1号").start();
        new Thread(web, "2号").start();
        new Thread(web, "3号").start();
    }
}
