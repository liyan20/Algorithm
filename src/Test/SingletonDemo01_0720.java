package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/20 16:08
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo01_0720 {
    private SingletonDemo01_0720(){

    }
    //初始化时，直接创建对象。static是在类加载的时候的，天然线程安全。
    // 但是如果后面没有用到这个对象，会造成浪费
    private static SingletonDemo01_0720 instance = new SingletonDemo01_0720();

    //没有synchronized，效率高
    //这里面必须是static的方法，因为没办法new这个对象的，所以没法调用普通方法
    public static SingletonDemo01_0720 getInstance(){
        return instance;
    }
}
