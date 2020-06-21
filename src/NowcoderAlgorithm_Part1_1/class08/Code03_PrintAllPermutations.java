package NowcoderAlgorithm_Part1_1.class08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/21 10:18
 * @Title&Description: 打印字符的全排列
 * 比如aac的结果就是aac,aca,caa这种是不重复的情况下
 * @Analysis:
 * 递归的原理分析：
 * 一个大规模的问题，拆分成小规模的问题，然后去执行。比如一个大问题拆分成小问题1，小问题2，小问题3
 * 那么，大问题是怎么样去调用小问题的，大问题一定是做了具体的决定，才接着调用小问题的。，比如大问题调用3个小问题，
 * 一定是大问题做了决定1调用了小问题1，做了决定2调用小问题2，做了决定3调用小问题3.
 * 那么在设计递归的时候，大问题做的决定，对小问题的影响，一定要在小问题的参数上都体现出来！！！重要！！
 * 否则递归是写不出来的，这就是为什么递归要那么多的参数。大问题所做的所有的决定的所有的影响，都要保证小问题在用到信息的时候是全的
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_PrintAllPermutations {
    public static void main(String[] args) {
        String str = "aac";
        System.out.println(Permutation(str));
    }

    public static Set<String> Permutation(String str){
        if (str == null){
            return null;
        }
        //这个set是保存str里面的所有的字符
        List<Character> set = new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            set.add(str.charAt(i));
        }
        Set<String> list = new HashSet<>();
        process(set, "", list);
        return list;
    }

    //这个是递归的函数
    //对于全排列来说，str里面的每一个字符都可以当成是开头，中间，第三个，第四个，，，结尾等等
    //set里面的每一个字符都可以当成当前字符，但是用过之后就不能用了，这边其实可以用一个boolean数组来表示是否用过
    public static void process(List<Character> set, String path, Set<String> list){
        //base case，即递归的返回条件，最后写
        //当set空了，就说明字符选完了，可以放入list了
        if (set.isEmpty()){
            list.add(path);
            return;
        }
        //index代表是set的第几个字符当第一个，利用递归进行分化，path记录字符的选择路径
        //每次考虑完当前字符之后，就把set里面的那个字符给去掉，交给下一个递归，同时在递归参数里面，
        //把path给加上之前的那个字符。这个不是用不用的问题，是选择哪一个的问题。直到去掉了字符的set空了
        //说明当前递归体的path走到头了，每个位置都选择了一个字符，可以放入list了。
        //关于每个位置是选的是啥，是根据for循环来解决的，for循环里面循环的是str的每一个字符，每一个字符都可以在
        //每一个位置出现的，所以这个，应该是可以用n重循环来解决。
        for (int index = 0; index < set.size(); index++){
            List<Character> next = new ArrayList<>(set);
            next.remove(index);
            process(next, path + set.get(index), list);
        }
    }
}
