package Java_Basic.Ini;

/**
 * @Author: xianz
 * @Date: 2020/9/15 22:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Father {
    public Father(){
        System.out.println("父类构造方法");
    }
    //普通成员变量，普通语句块
    public String s = "父类普通成员变量";
    {
        System.out.println("父类普通语句块");
    }
    //静态变量，静态语句块
    public static int n;
    static {
        System.out.println("父类静态语句块");
    }
}
