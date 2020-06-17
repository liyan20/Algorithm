package huawei;

/**
 * @Author: xianz
 * @Date: 2020/5/2 15:50
 * @Title: 成绩排序
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis
 * @TimeConsuming:
 */
import java.util.*;
public class Test_0502_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            Student.flag = sc.nextInt();
            sc.nextLine();
            List<Student> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                String str = sc.nextLine();
                String name = str.split(" ")[0];
                int score = Integer.valueOf(str.split(" ")[1]);
                Student obj = new Student(name, score);
                list.add(obj);
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
}
class Student implements Comparable<Student>{
    String name;
    int score;
    public static int flag;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {
        if(flag == 0){
            return o.score - score;
        }else{
            return score-o.score;
        }
    }
    @Override
    public String toString() {
        return name+" "+score;
    }
}
