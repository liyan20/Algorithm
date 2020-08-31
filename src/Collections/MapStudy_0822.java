package Collections;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xianz
 * @Date: 2020/8/22 10:48
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

public class MapStudy_0822 {



    public static void main(String[] args) {

        Hashtable hashtable;

        Lock lock = new ReentrantLock();

        AtomicInteger atomicInteger;

        PriorityQueue priorityQueue;


        try {
            Class.forName("Collections.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//        ThreadLocal


//        Method[] methods = Student.class.getDeclaredMethods();
//        for (Method m : methods){
//            m.isAnnotationPresent(MyInterface.class)
//        }
        WeakHashMap weakHashMap;
        long max = 1 << 30;
        System.out.println(max * 2);
        System.out.println(1 << 30);
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(1 << 30);
        String a = String.valueOf("gwerg56456");
        System.out.println(a.hashCode());
        int h = a.hashCode();
        System.out.println(h ^ (h >>> 16));
        System.out.println(h & 15);
        Hashtable hashtable2;
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        Collections.synchronizedMap(map);
        LinkedHashMap linkedHashMap;

//        HashSet hashSet;
//        Father father = new Father();
//        Son son = new Son();
//
//        Father f = (Father)son;
////        System.out.println(f.id);
//        Object o = (Object)a;
//        System.out.println(o);
//        Son s = (Son)father;
////        System.out.println(s.id);
//
//        Father father1 = new Son();
//        Son son1 = (Son)father1;
//        System.out.println(son1);

    }
}

