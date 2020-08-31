package Collections;

/**
 * @Author: xianz
 * @Date: 2020/8/31 08:55
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class CloneTest01_0831 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Major major = new Major("计算机", 666666);
        Student s1 = new Student("张三", 18, major);

        //clone回来的是Object类，要强制转型
        Student s2 = (Student)s1.clone();
        //判断两个对象是否一样，结果是false说明是两个对象
        System.out.println((s1 == s2));
        //判断两个对象的Major引用类型属性是否一样，结果是true，说明两个拷贝但是其中的引用类型是同一个
        System.out.println((s1.getMajor() == s2.getMajor()));
        System.out.println();

        //分别修改Student s1对象里面的基本类型和引用类型，看对两个对象是否有影响
        s1.setAge(30);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println();

        //修改引用类型属性
        major.setMajorId(2333);
        major.setMajorName("电子");
        System.out.println(s1);
        System.out.println(s2);
    }
}
