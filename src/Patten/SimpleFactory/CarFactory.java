package Patten.SimpleFactory;

/**
 * @Author: xianz
 * @Date: 2020/7/12 21:24
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class CarFactory {
    public static Car createAudi(){
        return new Audi();
    }

    public static Car createByd(){
        return new Byd();
    }
}
