package Interview.WYHY;

/**
 * @Author: xianz
 * @Date: 2020/8/12 19:38
 * @Title&Description:
 * 必须是147，258，369的数字，并且必须是W B T三个每个选一堆数字，然后随机扔掉两个。
 * 是否是字符串匹配的部分
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import com.sun.management.VMOption;

import java.util.*;
public class Test01_0812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int T = Integer.valueOf(sc.nextLine());
            String[] arr = new String[T];
            for (int i=0; i<T; i++){
                arr[i] = sc.nextLine();
            }
            for (int i=0; i<T; i++){
                if (solution(arr[i])){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

//    public static void main(String[] args) {
//        String[] arr1 = {"1T","4T","7T","2B","5B","8B","9W"};
//        String[] arr2 = {"1T","2T","3T","4T","5T","6T","7T"};
//        String[] arr3 = {"2B","8B","5B","2B","6T","7W","4W"};
//        System.out.println(solution(arr1));
//    }


    public static boolean solution(String str) {
        String[] arr = str.split(" ");
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] keyArr = new char[10];
        Arrays.fill(keyArr, '0');

        for (String temp : arr) {
            int num = Integer.valueOf(String.valueOf(temp.charAt(0)));
            char cha = temp.charAt(1);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            if (!map.containsKey(cha)){
                map.put(cha, 1);
            }else {
                map.put(cha, map.get(cha) + 1);
            }
            if (map.get(cha) > 3){
                return false;
            }
            keyArr[num] = cha;
        }
        boolean flag = true;
        for (int i = 1; i <= 3; i++) {
            int i1 = i;
            int i2 = i + 3;
            int i3 = i + 6;
            if (!set.contains(i1)) {
                flag = isEqual(keyArr[i2], keyArr[i3]);
            } else if (!set.contains(i2)) {
                flag = isEqual(keyArr[i1], keyArr[i3]);
            } else if (!set.contains(i3)) {
                flag = isEqual(keyArr[i1], keyArr[i2]);
            } else {
                return (keyArr[i1] == keyArr[i2]) && (keyArr[i2] == keyArr[i3]);
            }
        }
        return flag;
    }

    public static boolean isEqual(char a, char b){
        if (a == '0'){
            return true;
        }else if (b == '0'){
            return true;
        }else {
            return a == b;
        }
    }
}
