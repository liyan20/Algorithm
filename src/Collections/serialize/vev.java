package Collections.serialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/9/14 20:53
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class vev {

    public static void main(String[] args) {
//        Integer i = new Integer(100);
//        Integer j = new Integer(100);
//        System.out.println(i == j);

//        Integer i = Integer.valueOf(100);
//        Integer j = Integer.valueOf(100);



        Integer i = 200;
        Integer j = 200;
        System.out.println(i == j);
        List list = new ArrayList<Integer>();

        A a = new vev().new A();
        B b = new B();
        B.f();
        while (true){

        }
    }

    class A{
        public void fun111(){}
    }

    static class B{
        public static void f(){}
    }

}
