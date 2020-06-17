package Test;

/**
 * @Author: xianz
 * @Date: 2020/6/3 10:42
 * @Title&Description:
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Animal {
    public void print(){
        System.out.println("animal");
    }

    public static void main(String[] args) {
        Animal a1 = new dog();
        a1.print();
    }
}

class dog extends Animal{
    @Override
    public void print() {
        System.out.println("dog");
    }
}
