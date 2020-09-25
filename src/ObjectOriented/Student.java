package ObjectOriented;

/**
 * @Author: xianz
 * @Date: 2020/9/13 15:59
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Student {

    private int id;

    private String name;

    private Student(){

    }

    private static Student instance = new Student();

    public static Student getInstance(){
        return instance;
    }

}
