package Java_Basic.Ini;

/**
 * @Author: xianz
 * @Date: 2020/9/15 22:40
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class IniTest01 {
    public IniTest01(){
        System.out.println("构造方法");
    }
    //普通成员变量，普通语句块
    public String s = "普通成员变量";
    {
        System.out.println("普通语句块");
    }
    //静态变量，静态语句块
    public static int n;
    static {
        System.out.println("静态语句块");
    }

    public static void main(String[] args) {

    }


}
