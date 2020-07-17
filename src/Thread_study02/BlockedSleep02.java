package Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:18
 * @Title&Description:
 * sleep模拟休息
 * sleep之后进入阻塞，带着资源的，之后是进入就绪状态
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class BlockedSleep02 {
    static class Racer implements Runnable {
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
    }
}


