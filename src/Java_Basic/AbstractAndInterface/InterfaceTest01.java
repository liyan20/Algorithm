package Java_Basic.AbstractAndInterface;

/**
 * @Author: xianz
 * @Date: 2020/9/15 20:19
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class InterfaceTest01 implements InterfaceDemo {

    @Override
    public void f1() {

    }

    @Override
    public void abs() {

    }

    public static void main(String[] args) {
        InterfaceTest01 interfaceTest01 = new InterfaceTest01();
        interfaceTest01.f1();
        System.out.println(interfaceTest01.n1);
        System.out.println(interfaceTest01.n2);

    }
}
