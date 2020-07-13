package Thread_study01;

/**
 * @Author: xianz
 * @Date: 2020/7/13 16:03
 * @Title&Description: 静态代理
 * 实现公共接口：
 * 1.真实角色
 * 2.代理角色
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();;
    }
}

interface Marry{
    void happyMarry();
}
//真实角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥本月");
    }
}
//代理角色
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }
    private void ready(){
        System.out.println("布置桌面");
    }
    private void after(){
        System.out.println("闹玉兔");
    }
}
