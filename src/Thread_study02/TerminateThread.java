package Thread_study02;

/**
 * @Author: xianz
 * @Date: 2020/7/13 17:16
 * @Title&Description: 终止线程
 * 1.正常执行完毕：次数限制
 * 2.外部干涉：加入标识
 * 不要使用stop()方法
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class TerminateThread implements Runnable {
    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("C罗");
        new Thread(tt).start();

        for (int i=0; i<=99999999; i++){
            if (i == 88999999){
                tt.terminate();
                System.out.println("tt game over");
            }
//            System.out.println("main: " + i);
        }
    }

    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(name + ": " + i);
            i++;
        }
    }
    public void terminate(){
        this.flag = false;
    }
}
