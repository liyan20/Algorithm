//package ThreadStudy.Thread_study04;
//
///**
// * @Author: xianz
// * @Date: 2020/7/16 15:10
// * @Title&Description:
// * 每个线程自身的存储本地、局部区域
// * get,set,initialValue
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//public class ThreadLocalTest01 {
//    //更改初始值
//    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
////        protected Integer initialValue(){
////            return 200;
////        }
//    };
//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
//        threadLocal.set(99);
//        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
//
//        new Thread(new MyRun()).start();
//    }
//
//    public static class MyRun implements Runnable{
//        @Override
//        public void run() {
//            threadLocal.set((int)(Math.random()*99));
//            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
//        }
//    }
//}
