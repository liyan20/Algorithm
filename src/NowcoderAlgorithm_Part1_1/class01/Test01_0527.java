package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/5/27 22:28
 * @Title&Description: 查找和排序
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 * 示例：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * 从低到高
 * smith     67
 * jack      70
 * Tom      70
 * peter     96
 * 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开。
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<Student> list = new ArrayList<>();
            int num = Integer.valueOf(sc.nextLine());
            int order = Integer.valueOf(sc.nextLine());
            for(int i=0;i<num;i++){
                String temp = sc.nextLine();
                String name = temp.split(" ")[0];
                int score = Integer.valueOf(temp.split(" ")[1]);
                list.add(new Student(name, score));
                searchAndSort(list, order);
            }
            for(Student temp : list){
                System.out.println(temp);
            }
        }
    }
    public static void searchAndSort(List<Student> list,int order){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(order == 1){
                    return o1.score - o2.score;
                }else {
                    return o2.score - o1.score;
                }
            }
        });
    }
    public static class Student{
        String name;
        int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        @Override
        public String toString() {
            return name + " " + score;
        }
    }
}


