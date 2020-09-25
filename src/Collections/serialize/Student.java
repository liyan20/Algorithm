package Collections.serialize;

import java.io.*;

/**
 * @Author: xianz
 * @Date: 2020/8/31 10:56
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Student implements Serializable {


    private static final long serialVersionUID = -6122002828095244059L;
    private String name;
    private Integer age;
    private Integer score;
    private transient Integer id = 2333;
    private transient int id2 = 2333;
    private static String grade = "二年级";


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", id=" + id +
                ", id2=" + id2 +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static void serialize(  ) throws IOException {

        Student student = new Student();
        student.setName("CodeSheep");
        student.setAge( 18 );
        student.setScore( 1000 );

        //这边的意思应该是创建一个student.txt文件
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("student.txt") ) );
        objectOutputStream.writeObject( student );  //把这个对象保存在txt里面
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
    }

    public static void deserialize(  ) throws IOException, ClassNotFoundException {
        //读取这个txt文件
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("student.txt") ) );
        Student student = (Student) objectInputStream.readObject();  //反序列化
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( student );
    }

    private void readObject( ObjectInputStream objectInputStream ) throws IOException, ClassNotFoundException {

        // 调用默认的反序列化函数
        objectInputStream.defaultReadObject();

        // 手工检查反序列化后学生成绩的有效性，若发现有问题，即终止操作！
        if( 0 > score || 100 < score ) {
            throw new IllegalArgumentException("学生分数只能在0到100之间！");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        deserialize();
    }
}
