package Test;

import java.util.PrimitiveIterator;

/**
 * @Author: xianz
 * @Date: 2020/8/14 18:25
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class DLCSingleton {

    private DLCSingleton(){

    }

    private static volatile DLCSingleton instance;

    public static DLCSingleton getInstance(){
        if (instance == null){
            synchronized (DLCSingleton.class){
                if (instance == null){
                    instance = new DLCSingleton();
                }
            }
        }
        return instance;
    }

}
