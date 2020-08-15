package Interview.MEITUAN;

/**
 * @Author: xianz
 * @Date: 2020/8/15 16:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] arr = new int[n][2];
//            int[] arr1 = new int[n];
//            int[] arr2 = new int[n];
            for (int i=0; i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
//                arr1[i] = sc.nextInt();
//                arr2[i] = sc.nextInt();
            }
            System.out.println(Math.max(solution(arr, a, b), solution2(arr, a, b)));
        }
    }

//    public static void main(String[] args) {
//
//    }

    public static class Info{
        public int gain1;
        public int gain2;

        public Info(int gain1, int gain2) {
            this.gain1 = gain1;
            this.gain2 = gain2;
        }
    }

    public static int solution(int[][] arr, int a, int b){
        List<Info> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            Info newInfo = new Info(arr[i][0], arr[i][1]);
            list.add(newInfo);
        }
        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.gain1 - o1.gain1;
            }
        });
        int sum = 0;
        for (int i=0; i<a; i++){
            sum += list.get(i).gain1;
        }
        List<Info> list2 = new ArrayList<>();
        for (int i=a; i<list.size(); i++){
            list2.add(list.get(i));
        }
        Collections.sort(list2, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.gain2 - o1.gain2;
            }
        });
        for (int i=0; i<b; i++){
            sum += list2.get(i).gain2;
        }
        return sum;
    }

    public static int solution2(int[][] arr, int a, int b){
        List<Info> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            Info newInfo = new Info(arr[i][0], arr[i][1]);
            list.add(newInfo);
        }
        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.gain2 - o1.gain2;
            }
        });
        int sum = 0;
        for (int i=0; i<b; i++){
            sum += list.get(i).gain2;
        }
        List<Info> list2 = new ArrayList<>();
        for (int i=b; i<list.size(); i++){
            list2.add(list.get(i));
        }
        Collections.sort(list2, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.gain1 - o1.gain1;
            }
        });
        for (int i=0; i<b; i++){
            sum += list2.get(i).gain1;
        }
        return sum;
    }
}
