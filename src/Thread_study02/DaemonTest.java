package Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/15 09:54
 * @Title&Description:
 * 设置优先级。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class DaemonTest {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread t = new Thread(god);
        t.setDaemon(true);
        t.start();
        new Thread(you).start();
        System.out.println(Thread.currentThread().isAlive());
    }

    public static class You implements Runnable{
        @Override
        public void run() {
            for (int i=0; i<365; i++){
                System.out.println("enjoy life");
            }
            System.out.println("ooooooo");
        }
    }
    public static class God implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println("bless");
            }
        }
    }
}
