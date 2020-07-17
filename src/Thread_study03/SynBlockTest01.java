package Thread_study03;

/**
 * @Author: xianz
 * @Date: 2020/7/15 10:56
 * @Title&Description: 线程安全：在并发时保证数据准确性，效率尽可能高
 * synchronized同步块，目标更明确
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class SynBlockTest01 {
    public static void main(String[] args) {
        Account account = new Account(1000, "结婚礼金");
        Drawing you = new Drawing(account, 80, "可悲的你");
        Drawing wife = new Drawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }

    public static class Account{
        int money;
        String name;
        public Account(int money, String name) {
            this.money = money;
            this.name = name;
        }
    }
    //取钱的类
    public static class Drawing extends Thread{
        Account account; //取钱的账户
        int drawingMoney;  //取得钱数
        int pocketTotal;  //口袋的得总数

        public Drawing(Account account, int drawingMoney, String name) {
            super(name);
            this.account = account;
            this.drawingMoney = drawingMoney;
        }

        @Override
        public void run() {
            test();
        }

        //这里面锁的是Drawing这个对象，即this。我们需要锁的应该是Account对象，锁的目标不对
        public void test(){
            if (account.money <= 0){
                return;
            }
            synchronized (account){
                if (account.money - drawingMoney < 0){
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.money -= drawingMoney;
                pocketTotal += drawingMoney;
                System.out.println(this.getName() + "--账户余额为" + account.money);
                System.out.println(this.getName() + "--口袋的钱为" + pocketTotal);
            }
        }
    }
}
