package Interview.DAJIANG;

/**
 * @Author: xianz
 * @Date: 2020/8/16 19:42
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03_0816 {

    public static void main(String[] args) {
        test();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            System.out.println(solution(s, k));
        }
    }

    public static void test(){
        String s = "71245323308";
        int k = 5;
        System.out.println(solution(s, k));
    }

    public static int solution(String s, int k){
        if (k == s.length()){
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        process(k, 0, new ArrayList<>(), s, k, list);
        int min = Integer.MAX_VALUE;
        for (List<Integer> temp : list){
            min = Math.min(min, getNewString(s, temp));
        }
        return min;
    }

    /**
     *
     * @param rest 还剩下的去掉的数量
     * @param index 到了哪个位置了，判断的位置
     * @param path 路上添加的路径，即选择删除的位置
     * @param k
     * @param list
     */
    public static void process(int rest, int index, List<Integer> path, String s, int k,
                               List<List<Integer>> list){
        if (index == s.length()){
            return;
        }
        if (path.size() == k){
            List<Integer> temp = new ArrayList<>(path);
            list.add(temp);
            return;
        }
        //可以选择Index的也可以不选择
        process(rest, index + 1, new ArrayList<>(path), s, k, list);

        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(index);
        process(rest - 1, index + 1, newPath, s, k, list);
    }

    public static int getNewString(String s, List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (!list.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }


}
