package Collections.t2;

/**
 * @Author: xianz
 * @Date: 2020/9/6 09:58
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Testiplus_0906 extends Thread {

    int i = 0;
    @Override
    public void run() {
        while (i < 100){
            i++;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }

    public static void main(String[] args) {
        Testiplus_0906 test1 = new Testiplus_0906();
        Testiplus_0906 test2 = new Testiplus_0906();
        Testiplus_0906 test3 = new Testiplus_0906();
        test1.start();
        test2.start();
        test3.start();
    }
}

