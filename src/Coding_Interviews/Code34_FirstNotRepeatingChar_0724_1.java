package Coding_Interviews;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/24 21:13
 * @Title&Description: 	第一个只出现一次的字符位置
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @Analysis:
 * 应该是用hashset保存唯一的数，用list保存已经访问的数，list是有顺序的。
 * @Summary:
 * @TimeConsuming:
 */
public class Code34_FirstNotRepeatingChar_0724_1 {
    public static void main(String[] args) {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));
    }
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1){
            return -1;
        }
        Set<Character> set = new HashSet<>();
        List<InnerStr> list = new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            if (!set.contains(temp)){
                set.add(temp);
                list.add(new InnerStr(temp, i));
            }else {
                list.remove(new InnerStr(temp, i));
            }
        }
        return list.size() == 0 ? -1 : list.get(0).index;
    }

    public static class InnerStr{
        public char aChar;
        public int index;
        public InnerStr(char aChar, int index) {
            this.aChar = aChar;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerStr innerStr = (InnerStr) o;
            return aChar == innerStr.aChar;
        }

        @Override
        public int hashCode() {
            return Objects.hash(aChar);
        }
    }
}
