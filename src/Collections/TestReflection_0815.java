//package Collections;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.util.*;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @Author: xianz
// * @Date: 2020/8/15 10:05
// * @Title&Description:
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//public class TestReflection_0815 {
//    private int id;
//    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        lock.lock();
//        lock.unlock();
//
//
//        Class cla = s.getClass();
//        System.out.println(cla.getName());
//        for (Field field : cla.getFields()){
//            System.out.println(field);
//        }
//
////        s.getClass().getClassLoader().loadClass(s.getClass().toString());
//        try {
//            Student s2 = s.getClass().newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            System.out.println(Class.forName("Collections.Student"));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public class inner{
//        int a = id;
//    }
//
//}
