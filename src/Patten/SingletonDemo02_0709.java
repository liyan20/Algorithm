package Patten;

/**
 * @Author: xianz
 * @Date: 2020/7/9 16:23
 * @Title&Description: 懒汉模式
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo02_0709 {
    private SingletonDemo02_0709(){
    }

    //初始化时，不直接创建对象。延迟加载
    private static SingletonDemo02_0709 instance;

    //线程同步，效率较低
    public static synchronized SingletonDemo02_0709 getInstance(){
        if (instance == null){
            instance = new SingletonDemo02_0709();
        }
        return instance;
    }
}
