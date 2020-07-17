package Thread_study03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/15 15:55
 * @Title&Description:
 * 优化：把位置体现出来，使用两个容器
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class HappyCinema02 {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(1);
        seats2.add(2);
        seats2.add(6);
        LISTCinema cinema = new LISTCinema(available, "happy LIST LAB");
        new Thread(new Customer(cinema, seats1), "老王").start();
        Thread t = new Thread(new Customer(cinema, seats2), "老吴");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    //顾客类。多个顾客买票，多线程
    public static class Customer implements Runnable{
        LISTCinema cinema;
        List<Integer> seats;
        public Customer(LISTCinema cinema, List<Integer> seats) {
            this.cinema = cinema;
            this.seats = seats;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (cinema){
                boolean flag = cinema.bookTickets(seats);
                if (flag){
                    System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为" + seats);
                }else {
                    System.out.println("出票失败" + Thread.currentThread().getName() + "-->位置不够");
                }
            }
        }
    }

    //影院类
    public static class LISTCinema{
        List<Integer> available; //可用的位置
        String name;  //名称
        public LISTCinema(List<Integer> available, String name) {
            this.available = available;
            this.name = name;
        }

        //购票，选择几个位置
        public boolean bookTickets(List<Integer> seats){
            System.out.println("可用位置为：" + available);
            List<Integer> copy = new ArrayList<>(available);
            copy.removeAll(seats); //相减
            if (available.size() - copy.size() != seats.size()){
                return false;
            }
            //如果数量对的上，就把相减后的赋值给available
            available = copy;
            return true;
        }
    }
}
