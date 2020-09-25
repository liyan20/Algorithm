package ThreadStudy.Thread_study01;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:27
 * @Title&Description: 龟兔赛跑
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Racer implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int steps=1; steps<=100; steps++){
            if (Thread.currentThread().getName().equals("兔子") && steps % 10 == 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "——" + steps);
            boolean flag = gameOver(steps);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        if (winner != null){ //存在胜利者
            return true;
        }else {
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner == > " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "乌龟").start();
        new Thread(racer, "兔子").start();
    }
}
