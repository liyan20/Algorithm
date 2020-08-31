package Test;

/**
 * @Author: xianz
 * @Date: 2020/8/24 19:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test0824 {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
    }

    public static class Father{}

    public static class Son extends Father{}
}
