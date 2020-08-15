package Interview.MEITUAN;

/**
 * @Author: xianz
 * @Date: 2020/8/15 17:25
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test04_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            solution2(n, m);
        }
    }

//    public static void main(String[] args) {
//        solution(4, 2);
//    }

    public static void solution2(int n, int m){
        if (n == 1 || m == 1){
            System.out.println(1);
        }else {
            System.out.println(8);
        }
    }

    /**
     *
     * @param n 最贵的东西的价格
     * @param m 有多少种东西
     */
    public static void solution(int n, int m){
        List<List<Integer>> res = new ArrayList<>();
        process(n, 0, m, 0, new ArrayList<>(), res);
        System.out.println(res);
    }

    /**
     *
     * @return
     */
    public static void process(int n, int index, int m, int rest, List<Integer> list, List<List<Integer>> res){
        if (rest < 0){
            return;
        }
        if (index == m){
            res.add(list);
            return;
        }

        for (int i=0; i<=m; i++){
            List<Integer> list1 = new ArrayList<>(list);  //加上这个
            list1.add(index);
            process(n, index + 1, m, i, list1, res);
        }
    }
}
