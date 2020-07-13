package Patten.SimpleFactory;

/**
 * @Author: xianz
 * @Date: 2020/7/12 21:25
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Client01 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createAudi();
        Car c2 = CarFactory.createByd();
        c1.run();
        c2.run();
    }
}
