package Test;

/**
 * @Author: xianz
 * @Date: 2020/8/12 16:51
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test0812 {
    public static void main(String[] args) {
        String str = "abc";
        Object object = new Object();
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
