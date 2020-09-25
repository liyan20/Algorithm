package ThreadStudy.Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 19:45
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 cinema = new Web12306(4, "happy LIST LAB");
        new Passenger(cinema, "老王", 2).start();
        new Passenger(cinema, "老吴", 1).start();
    }

    //顾客类。多个顾客买票，多线程
    public static class Passenger extends Thread{
        Web12306 cinema;
        int seats;
        public Passenger(Runnable target, String name, int seats) {
            super(target, name);
            this.seats = seats;
        }
    }

    //火车票类
    public static class Web12306 implements Runnable{
        int available; //可用的位置
        String name;  //名称
        public Web12306(int available, String name) {
            this.available = available;
            this.name = name;
        }

        @Override
        public void run() {
            Passenger p = (Passenger) Thread.currentThread();
            boolean flag = this.bookTickets(p.seats);
            if (flag){
                System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为" + p.seats);
            }else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-->位置不够");
            }
        }

        //购票，选择几个位置
        public synchronized boolean bookTickets(int seats){
            System.out.println("可用位置为：" + available);
            if (seats > available){
                return false;
            }
            available -= seats;
            return true;
        }
    }
}
