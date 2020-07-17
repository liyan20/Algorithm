package Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:40
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class BlockJoin02 {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();
    }

    static class Father extends Thread{
        @Override
        public void run() {
            System.out.println("想抽烟没烟了");
            System.out.println("让儿子买烟");
            Thread t = new Thread(new Son());
            t.start();
            try {
                t.join(); //join写在Father的线程体内，Father被阻塞
                System.out.println("老爸接过烟，把零钱给儿子");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("孩子走丢了");
            }
        }
    }

    static class Son extends Thread{
        @Override
        public void run() {
            System.out.println("接过老爸的钱出去了");
            System.out.println("路边有个游戏厅玩了10秒");
            for (int i=0; i<10; i++){
                System.out.println(i+1 + "秒过去了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("赶紧买烟去");
            System.out.println("手拿一包中华回家");
        }
    }


}

