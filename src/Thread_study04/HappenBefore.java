package Thread_study04;

/**
 * @Author: xianz
 * @Date: 2020/7/16 11:16
 * @Title&Description:
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        //线程1读取数据
        for (int i=0; i<10000; i++){
            a = 0;
            flag = false;
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            //线程2更改数据
            Thread t2 = new Thread(()->{
                if (flag){
                    a *= 1;
                }
                if (a == 0){
                    System.out.println("happen before a-->" + a);
                }
            });
            t1.start();
            t2.start();
            //线程插队，合并线程
            t1.join();
            t2.join();
        }
    }
}
