package Patten;

/**
 * @Author: xianz
 * @Date: 2020/8/8 08:37
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SingletonDemo04_0808 {
    private SingletonDemo04_0808(){

    }

    private volatile static SingletonDemo04_0808 instance;


    public static SingletonDemo04_0808 getinstance() {
        if (instance == null) {
            synchronized (SingletonDemo04_0808.class) {
                if (instance == null) {
                    instance = new SingletonDemo04_0808();
                }
            }
        }
        return instance;
    }
}
