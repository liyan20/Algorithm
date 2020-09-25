package Interview.XIECHENG2;



/**
 * @Author: xianz
 * @Date: 2020/9/8 19:24
 * @Title&Description:
 * 考虑实现一个敏感词过滤的功能，给定指定的敏感单词、句子、替换词，把句子中的敏感单词词全部替换成替换词。
 *
 * 注意替换过程中敏感词需要忽略字母顺序，例如you这个敏感词，句子里如果出现oyu、uyo等，
 * 也同样需要进行替换，以免有人利用不影响人类理解的错误字母顺序钻空子。
 * 输入描述
 * 输入为三行内容：
 * 第一行是敏感单词
 * 第二行是待检测的句子
 * 第三行是替换的目标词
 *
 * 输出描述
 * 输出替换好敏感词的句子
 * @Analysis:
 * you
 * i love you,oyu love me
 * jack
 * 样例输出
 * i love jack,jack love me
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0908 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String oldWord = sc.nextLine();
            String sentence = sc.nextLine();
            String replaceWord = sc.nextLine();
            solution(oldWord, sentence, replaceWord);
        }
    }

    public static void solution(String oldWord, String sentence, String replaceWord){
        if (oldWord.length() > sentence.length()){
            System.out.println(sentence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i=0; i + oldWord.length() <= sentence.length();){
            String s1 = sentence.substring(i, i + oldWord.length());
            if (isSame(s1, oldWord)){
                sb.append(replaceWord);
                i += oldWord.length();
            }else {
                sb.append(sentence.charAt(i));
                i++;
            }
        }
        if (i < sentence.length()){
            sb.append(sentence.substring(i));
        }
        System.out.println(sb.toString());
    }

    //判断两个字符串是否是字母异位词
    public static boolean isSame(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i=0; i<chars1.length; i++){
            if (chars1[i] != chars2[i]){
                return false;
            }
        }
        return true;
    }
}
