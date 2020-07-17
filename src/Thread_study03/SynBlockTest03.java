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
public class SynBlockTest03 {
    public static class Web12306 implements Runnable {
        //票数
        private int ticketNums = 9;
        private boolean flag = true;
        @Override
        public void run() {
            while (flag){
                test5();
            }
        }

        //线程安全：尽可能锁定合适的范围
        public void test5(){
            if (ticketNums < 0){  //这里面考虑的是没有票的情况。
                flag = false;
                return;
            }
            synchronized (this){
                if (ticketNums < 0){  //这里面考虑的是最后一张票的情况。
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

        public void test4(){
            //只锁了一部分，范围太小锁不住的
            synchronized (this){
                if (ticketNums < 0){
                    flag = false;
                    return;
                }
            }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "—>" + ticketNums--);
        }

        public void test3(){
            //只锁ticketNums，注意要转成引用类型
            //ticketNums对象在变
            synchronized ((Integer)ticketNums){
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

        public void test2(){
            //这里面flag和ticketNums涉及到修改操作，是要上锁的，但是没法传两个参数。
            //这两个正好属于类Web12306，直接锁this就行
            synchronized (this){
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

        public synchronized void test(){
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
