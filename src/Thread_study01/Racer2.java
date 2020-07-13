package Thread_study01;

import java.util.concurrent.*;

/**
 * @Author: xianz
 * @Date: 2020/7/13 15:27
 * @Title&Description: 龟兔赛跑
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Racer2 implements Callable<Integer> {
    private String winner;
    @Override
    public Integer call() throws Exception {
        for (int steps=1; steps<=100; steps++){
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps % 10 == 0){
                Thread.sleep(200);
            }
            System.out.println(Thread.currentThread().getName() + "——" + steps);
            boolean flag = gameOver(steps);
            if (flag){
                return steps;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Racer2 racer = new Racer2();
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + "->" + r2);
        ser.shutdownNow();
    }
}
