package Patten;

/**
 * @Author: xianz
 * @Date: 2020/7/9 16:13
 * @Title&Description: 单例模式-饿汉模式
 * 不需要加synchronized，因为都是static是在类加载的时候的，天然线程安全
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo01_0709 {
    private SingletonDemo01_0709(){
    }

    //初始化时，直接创建对象。但是如果后面没有用到这个对象，会造成浪费
    private static SingletonDemo01_0709 instance = new SingletonDemo01_0709();

    //没有synchronized，效率高
    public static SingletonDemo01_0709 getInstance(){
        return instance;
    }
}
