package ThreadStudy.Thread_study02;


/**
 * @Author: xianz
 * @Date: 2020/7/14 09:53
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i=0; i<5; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".....");
            }
        });
        //观察状态
        Thread.State state = t.getState();  //NEW
        System.out.println(state);

        t.start();
        state = t.getState();  //RUNNABLE
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();  //TIMED_WAITING
            System.out.println(state);
        }
        state = t.getState();  //TERMINATED
        System.out.println(state);
    }
}
