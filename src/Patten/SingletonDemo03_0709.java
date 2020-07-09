package Patten;

/**
 * @Author: xianz
 * @Date: 2020/7/9 16:33
 * @Title&Description: 静态内部类实现单例模式
 * @Analysis: 效率高，线程安全，并且实现了延迟加载
 * 外部类没有静态属性，不会直接加载。内部类加载时候线程安全。没有同步方法，效率高
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo03_0709 {
    private SingletonDemo03_0709(){
    }

    private static class SingletonClassInstance{
        private static SingletonDemo03_0709 instance = new SingletonDemo03_0709();
    }

    public static SingletonDemo03_0709 getInstance(){
        return SingletonClassInstance.instance;
    }
}
