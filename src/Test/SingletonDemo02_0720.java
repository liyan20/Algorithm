package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/20 16:18
 * @Title&Description: 懒汉式 线程安全写法
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo02_0720 {
    private SingletonDemo02_0720(){

    }

    private static SingletonDemo02_0720 instance;

    public static synchronized SingletonDemo02_0720 getInstance(){
        if (instance != null){
            return new SingletonDemo02_0720();
        }
        return instance;
    }
}
