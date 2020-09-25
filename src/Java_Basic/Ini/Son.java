package Java_Basic.Ini;

/**
 * @Author: xianz
 * @Date: 2020/9/15 22:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Son extends Father {
    public Son(){
        System.out.println("子类构造方法");
    }
    //普通成员变量，普通语句块
    public String s = "子类普通成员变量";
    {
        System.out.println("子类普通语句块");
    }
    //静态变量，静态语句块
    public static int n;
    static {
        System.out.println("子类静态语句块");
    }

    public static void main(String[] args) {
//        System.out.println("第一次加载子类");
        Son son = new Son();
        System.out.println("***********************");
        System.out.println();
        System.out.println("第二次加载子类: ");
        System.out.println();
        Son s2 = new Son();
    }
}
