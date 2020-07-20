package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/20 16:30
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class TestInnerClass_0720 {
    //构造方法
    public TestInnerClass_0720(){
        System.out.println("加载外部类");
    }

    public class Inner{
        public void method(){
            System.out.println("我是内部类1");
        }
    }
    public static class Inner2{
        public void method(){
            System.out.println("我是内部类2");
        }
    }
    public static void main(String[] args) {
//        TestInnerClass_0720 t = new TestInnerClass_0720();
//        TestInnerClass_0720.Inner inner = t.new Inner();
//        inner.method();
        TestInnerClass_0720.Inner2 inner2 = new TestInnerClass_0720.Inner2();
        inner2.method();
    }
}
