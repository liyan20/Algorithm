package Interview.YFD;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/8/1 18:58
 * @Title&Description:
 * 输入是课程的起止时间。
 * 课程之间可以重复。小袁可以一心多用同时上K门课，问需要最少K是多少可以上上完买的课。
 * 个人觉得这个是计算在某一个时间，有多少门课在同时上，求这个最大值。
 * 可能难点在时间复杂度上面。感觉是不是滑动窗口啊。滑的范围是从0到课程的最大值。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i=0; i<N; i++){
                int[] arr = new int[2];
                arr[0] = sc.nextInt();
                arr[1] = sc.nextInt();
                list.add(arr);
            }
            System.out.println(minTimes(list));
        }
    }

//    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//        list.add(new int[] {1,4});
//        list.add(new int[] {1,2});
//        list.add(new int[] {2,3});
//        list.add(new int[] {3,4});
//        System.out.println(minTimes(list));
//    }

    public static int minTimes(List<int[]> list){
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;  //最大的终点
        for (int i=0; i<list.size(); i++){
            start = Math.min(start, list.get(i)[0]);
            end = Math.max(end, list.get(i)[1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i=start; i<end; i++){
            int res = 0;
            for (int j=0; j<list.size(); j++){
                int curStart = list.get(j)[0];
                int curEnd = list.get(j)[1];
                if (i >= curStart && i < curEnd){
                    res++;
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }
}
