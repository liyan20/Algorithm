package Collections;

import java.io.*;
import java.util.Objects;

/**
 * @Author: xianz
 * @Date: 2020/8/2 22:02
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Student implements Cloneable,Serializable  {

    private String name;
    private int age;
    private Major major;

    //重写Object类的clone方法。并且要在里面赋值major属性的一个拷贝
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Student student = (Student)super.clone();
//        student.major = (Major)major.clone();
//        return student;
//    }

//    @Override

    public Student clone() {
        try {
            // 将对象本身序列化到字节流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream( byteArrayOutputStream );
            objectOutputStream.writeObject( this );

            // 再将字节流通过反序列化方式得到对象副本
            ObjectInputStream objectInputStream =
                    new ObjectInputStream( new ByteArrayInputStream( byteArrayOutputStream.toByteArray() ) );
            return (Student) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
