package NowcoderAlgorithm_Part1_1.class08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/20 20:07
 * @Title&Description: 打印一个字符串的所有子串，包括空的
 * 比如abc的子串是空，a,b,c,ab,ac.bc.abc
 * 方法：
 * 从左到右依次试的模型
 * 每遇到一个字符，都可以选择要这个字符或者选择不要这个字符，每一次的选择用path保存下来，到最后一个字符的时候，将path加入list
 *
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code02_PrintAllSubsquences {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(getAllSubs(str));
    }

    public static List<String> getAllSubs(String str){
        List<String> list = new ArrayList<>();
        if (str == null){
            return null;
        }
        if (str.length() == 0){
            list.add("");
            return list;
        }
        process(str, 0, "", list);
        return list;
    }

    //index是指的目前在处理哪个字符，path是指的在index之前的字符的路径记录，即之前的每一个字符是要还是不要
    //最终每一个递归产生的path到最后一个字符的时候就放入list
    public static void process(String str, int index, String path, List<String> list){
        //递归结束的条件：当index到字符串的最后的时候，就放入list，return
        if (index == str.length()){
            list.add(path);
            return;
        }
        //针对当前index对应的字符，我们有两种选择，一个是要这个字符，一个是不要这个字符
        //不要的话，下一个递归就不动path，要的话下一个递归就把path加上当前的字符
        process(str, index + 1, path, list);
        process(str, index + 1, path + str.charAt(index), list);
    }
}
