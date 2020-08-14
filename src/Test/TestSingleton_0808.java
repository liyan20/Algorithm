package Test;

/**
 * @Author: xianz
 * @Date: 2020/8/8 08:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class TestSingleton_0808 {
    private TestSingleton_0808(){

    }

    private volatile static TestSingleton_0808 instance;

    public static TestSingleton_0808 getInstance(){
        if (instance == null){
            synchronized(TestSingleton_0808.class){
                if (instance == null){
                    instance = new TestSingleton_0808();
                }
            }
        }
        return instance;
    }
}
