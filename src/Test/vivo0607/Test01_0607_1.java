package Test.vivo0607;

/**
 * @Author: xianz
 * @Date: 2020/6/7 15:15
 * @Title&Description:
 * @Analysis: 经过计算，是有n个0的情况下，可以有的数量是 (n-1)/2
 * 如果是开头不是1或者结尾不是1，那么情况下就是n/2
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0607_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i=0; i<num; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(maxNum(arr));
        }
    }

    public static int maxNum(int[] arr){
        if (arr.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int zeroNum = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == 1){
                list.add(i);
            }
        }
        if (list.size() == 0){
            return (arr.length + 1) / 2;
        }
        if (list.size() == 1){
            return (list.get(0) / 2) + (arr.length -1 - list.get(0)) / 2;
        }
        for (int i=1; i<list.size(); i++){
            list2.add(list.get(i) - list.get(i-1) - 1);
        }
        for (int i=0; i<list2.size(); i++){
            zeroNum += (list2.get(i) - 1) / 2;
        }
        zeroNum += (list.get(0) / 2) + (arr.length - 1 - list.get(list.size()-1)) / 2;
        return zeroNum;
    }
}
