package Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 15:55
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(2, "happy LIST LAB");
        new Thread(new Customer(cinema, 2), "老王").start();
        new Thread(new Customer(cinema, 1), "老吴").start();
    }

    //顾客类。多个顾客买票，多线程
    public static class Customer implements Runnable{
        Cinema cinema;
        int seats;
        public Customer(Cinema cinema, int seats) {
            this.cinema = cinema;
            this.seats = seats;
        }
        @Override
        public void run() {
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
    public static class Cinema{
        int available; //可用的位置
        String name;  //名称
        public Cinema(int available, String name) {
            this.available = available;
            this.name = name;
        }

        //购票，选择几个位置
        public boolean bookTickets(int seats){
            System.out.println("可用位置为：" + available);
            if (seats > available){
                return false;
            }
            available -= seats;
            return true;
        }
    }
}
