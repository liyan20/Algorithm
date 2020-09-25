package ThreadStudy.Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 20:03
 * @Title&Description:
 * 死锁：过多的同步可能造成互相不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 * 避免：不要在一个代码块中同时持有多个对象的锁
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(1, "大丫");
        Makeup g2 = new Makeup(0, "王菲");
        g1.start();
        g2.start();
    }

    public static class Lipstick{

    }
    public static class Mirror{

    }
    public static class Makeup extends Thread{
        static Lipstick lipstick = new Lipstick();
        static Mirror mirror = new Mirror();
        int choice;
        String girl;
        public Makeup(int choice, String girl){
            this.choice = choice;
            this.girl = girl;
        }
        @Override
        public void run() {
            makeup();
        }
        //相互持有对方的对象锁
        private void makeup()  {
            if (choice == 0){
                synchronized (lipstick){
                    System.out.println(this.girl+"涂口红");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (mirror){
                        System.out.println(this.girl+"照镜子");
                    }
                }
            }else {
                synchronized (mirror){
                    System.out.println(this.girl+"照镜子");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lipstick){
                        System.out.println(this.girl+"涂口红");
                    }
                }

            }
        }
    }

}
