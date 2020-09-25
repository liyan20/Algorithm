package ThreadStudy.Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/14 09:34
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class YieldDemo02 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("lambda" + i);
            }
        }).start();
        for (int i=0; i<100; i++){
            if (i % 20 == 0){
                Thread.yield();  //main线程礼让
            }
            System.out.println("main" + i);
        }
    }


}
