package Interview.XIECHENG;

/**
 * @Author: xianz
 * @Date: 2020/8/15 19:02
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0815 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int k = sc.nextInt();
//            solution(a, b, k);
//
//        }
//    }

    public static void main(String[] args) {
        solution2(1, 2, 3);
    }

    public static void solution2(int a, int b, int k){
        if (k == 0){
            System.out.println("[]");
            return;
        }
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int i=0; i<=k; i++){
            sum = (long)(i * a) + (long)((k-i) * b);
            set.add(sum);
        }
        List<Long> list = new ArrayList<>();
        for (long temp : set){
            list.add(temp);
        }
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int)(o1 - o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            if (i != list.size()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    /**
     * a和b是两种规格的瓷砖，任取k块
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static void solution(int a, int b, int k){
        Set<Integer> set = new HashSet<>();
        int[] cache = new int[k];
        Arrays.fill(cache, -1);
        process(0, a, b, k, 0, set);
        List<Integer> list = new ArrayList<>();
        for (int temp : set){
            list.add(temp);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            if (i != list.size()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    public static void process(int index, int a, int b, int k, int path, Set<Integer> set){
        if (index == k){
            set.add(path);
            return;
        }
        process(index + 1, a, b, k, path + a, set);
        process(index + 1, a, b, k, path + b, set);
    }
}
