package Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:11
 * @Title&Description:
 * 并发操作：同一个对象被多个线程同时操作
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class UnsafeTest01 {
    public static class Web12306 implements Runnable {
        //票数
        private int ticketNums = 9;
        private boolean flag = true;
        @Override
        public void run() {
            while (flag){
                test();
            }
        }

        public void test(){
            while (flag){
                if (ticketNums < 0){
                    flag = false;
                    return;
                }
                try {
                    Thread.sleep(200);
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
}
