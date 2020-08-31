package Interview.VIPKID;

/**
 * @Author: xianz
 * @Date: 2020/8/28 19:31
 * @Title&Description:
找到最短转换序列长度
时间限制： 3000MS
内存限制： 589824KB
题目描述：
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同
 * @Analysis:
 * 样例输入
 * hit
 * cog
 * hot dot dog lot log cog
 * 样例输出
 *  5
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test01_0828 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String strList = sc.nextLine();
            solution(s1, s2, strList);
        }
    }

//    public static void test(){
//        String s = "3+8*2-6/4";
//        solution(s);
//    }

    //BFS思想，每次变换查找就完事了
    public static void solution(String s1, String s2, String strList){
        String[] wordList = strList.split(" ");
        Deque<String> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[wordList.length];
        queue.offerLast(s1);

        int levelNum = 0;
        while (!queue.isEmpty()){
            levelNum++;
            String cur = queue.pollFirst();
            //针对每一个当前的，进行查找所有的字典就行了
            for (int i=0; i<wordList.length; i++){
                //访问过了继续下一个
                if (isVisited[i]){
                    continue;
                }
                if (isValid(cur, wordList[i])){
                    //如果就是存在于字典里面，直接返回
                    if (wordList[i].equals(s2)){
                        System.out.println(levelNum);
                        return;
                    }else {
                        queue.offerLast(wordList[i]);
                        isVisited[i] = true;
                    }
                }
            }
        }
        //到这边没有返回的话，levelNum已经失去意义了，返回0
        System.out.println(0);
        return;
    }

    public static boolean isValid(String s1, String s2){
        int difference = 0;
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                difference++;
            }
        }
        return difference == 1;
    }
}
