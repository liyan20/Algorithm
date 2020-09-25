//package ThreadStudy.Thread_study04;
//
///**
// * @Author: xianz
// * @Date: 2020/7/16 15:10
// * @Title&Description:
// * 每个线程存储自身的数据，更改不会影响其他线程
// * get,set,initialValue
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//public class ThreadLocalTest02 {
//    //更改初始值
//    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
//        protected Integer initialValue(){
//            return 200;
//        }
//    };
//    public static void main(String[] args) {
//        for (int i=0; i<5; i++){
//            new Thread(new MyRun()).start();
//        }
//    }
//
//    public static class MyRun implements Runnable{
//        @Override
//        public void run() {
//            Integer left = threadLocal.get();
//            System.out.println(Thread.currentThread().getName() + "得到了-->" + threadLocal.get());
//            threadLocal.set(left-1);
//            System.out.println(Thread.currentThread().getName() + "还剩下-->" + threadLocal.get());
//        }
//    }
//}
