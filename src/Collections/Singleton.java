package Collections;

/**
 * @Author: xianz
 * @Date: 2020/9/2 19:52
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

public class Singleton {

    private static Singleton instance;

    /**
     * 防止反射破坏。主要思路是第一次被调用的时候就将这个变量置为false，
     * 不管是反射创建的还是getInstance创建的
     */
    private static boolean isFristCreate = true; //默认是第一次创建
    private Singleton(){
        if (isFristCreate){
            synchronized (Singleton.class){
                if (isFristCreate){
                    isFristCreate = false;  //只要被调用一次，就置为false
                }
            }
        }else {
            throw new RuntimeException("该类已经被实例化！");
        }
    }

    /**
     * 正常的双重校验锁的单例模式
     * @return
     */
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 防止拷贝破坏。直接重写clone方法，返回实例对象
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    /**
     * 防止反序列化破坏
     */
    private Object readResolve(){
        return instance;
    }
}
