package ObjectOriented;



/**
 * @Author: xianz
 * @Date: 2020/9/13 16:01
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class ReflectDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student s = Student.getInstance();
        System.out.println(s);

        //利用反射新建一个Student对象
        Class clazz = s.getClass();
        Constructor c0 = clazz.getDeclaredConstructor();
        c0.setAccessible(true);
        Student s2 = (Student)c0.newInstance();
        System.out.println(s2);
    }

}
