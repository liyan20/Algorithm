package Interview.DUXIAOMAN;

/**
 * @Author: xianz
 * @Date: 2020/9/20 21:02
 * @Title&Description:
 * 小明发现有的字符串中蕴含着一些规律，但是它们又和普通的周期串有点不一样。例如：ABCABDABDABE。
 * 如果以3为周期，可以看到其中包含“ABC”、“ABD”和“ABE”等子串，其中“ABD”出现了两次。
 *
 * 这些子串两两之间最多只有某一位上的字符不相同，其他位置上的字符都一样。小明将其称为“近似串”，
 * 由多个“近似串”组成的字符串称为“近似周期串”。“近似周期串”中的每一个“近似串”的长度需大于等于2。
 *
 * 需要注意的是“ABCABBACD”并不是一个“近似周期串”。如果以3为周期，其子串包括“ABC”、“ABB”和“ACD”，“
 * ABB”与“ACD”、“ABC”与“ACD”均存在两个位置上的字符不相同，因此不是“近似周期串”。
 * 特别的，“AAAAAA”也是一个“近似周期串”，因为它满足上述“近似周期串”的定义。
 *
 * 现在给你一个字符串，请编写一个程序判断该字符串是否是以3为周期的“近似周期串”。
 * 输入描述
 * 多组输入，第1行输入一个正整数T表示输入数据的组数。
 * 对于每一组输入数据：输入一个长度不超过1000的字符串，字符串中只包含大写英文字母。
 * 输出描述
 * 针对每一组输入数据，输出该字符串是否是以3为周期的“近似周期串”，如果是输出“Yes”，否则输出“No”。
 * 样例输入
 * 2
 * ABCABDABDABEABEABF
 * ABCABDAEC
 * 样例输出
 * Yes
 * No

 */


import java.util.*;
public class Test01_0920 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] arr = new String[n];
            for (int i=0; i<n; i++){
                arr[i] = sc.nextLine();
            }
            for (int i=0; i<arr.length; i++){
                System.out.println(solution(arr[i]));
            }
        }
    }
    public static String solution(String s){
        if (s.length() <= 3){
            return "Yes";
        }
        if (s.length() % 3 != 0){
            return "No";
        }
        String[] arr = new String[s.length() / 3];
        int index = 0;
        for (int i=0; i<s.length(); i+=3){
            arr[index] = s.substring(i, i+3);
            index++;
        }
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (!isSame(arr[i], arr[j])){
                    return "No";
                }
            }
        }
        return "Yes";
    }

    public static boolean isSame(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        int sum = 0;
        while (p1 < s1.length() && p2 < s2.length()){
            if (arr1[p1] < arr2[p2]){
                p1++;
            }else if (arr1[p1] > arr2[p2]){
                p2++;
            }else if (arr1[p1] == arr2[p2]){
                p1++;
                p2++;
                sum++;
            }
        }
        return sum >= 2;
    }
}
