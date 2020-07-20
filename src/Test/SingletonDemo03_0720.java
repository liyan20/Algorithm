package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/20 16:24
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
//效率高，线程安全，并且实现了延迟加载
//内部类不会在外部类加载的时候直接加载。内部类加载时候线程安全。没有同步方法，效率高
public class SingletonDemo03_0720 {
    private SingletonDemo03_0720(){

    }

    private static class SingletonClassInstance{
        private static SingletonDemo03_0720 instance = new SingletonDemo03_0720();
    }

    public static SingletonDemo03_0720 getInstance(){
        return SingletonClassInstance.instance;
    }
}
