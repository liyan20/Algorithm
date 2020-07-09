package Test;

import java.lang.reflect.Field;

/**
 * @Author: xianz
 * @Date: 2020/7/9 08:45
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test_0709_1 {
    private int age;
    public String name;
    public int id;

    public static void main(String[] args) {
        Test_0709_1 test = new Test_0709_1();
        String path = "Test.Test_0709_1";
        System.out.println();
        try {
            Class clazz = Class.forName(path);
            Class cla2 = test.getClass();
            Class cla3 = Test_0709_1.class;
            System.out.println(cla2.getName());
            Field[] fields = cla2.getFields();
            for (Field i : fields){
                System.out.println(i);
            }
            System.out.println(cla2.getField("name"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
class A{
    public static int id;
}
