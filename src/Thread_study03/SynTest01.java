package Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:56
 * @Title&Description: 线程安全：在并发时保证数据准确性，效率尽可能高
 * synchronized同步方法
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SynTest01 {
    public static class Web12306 implements Runnable {
        //票数
        private int ticketNums = 9999;
        private boolean flag = true;
        @Override
        public void run() {
            while (flag){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test();
            }
        }

        //锁了对象的资源
        public synchronized void test(){
            if (ticketNums < 0){
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "—>" + ticketNums--);
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
