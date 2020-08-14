package Interview.WYHY;

/**
 * @Author: xianz
 * @Date: 2020/8/12 20:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i=0; i<N; i++){
                List<Integer> newList = new ArrayList<>();
                for (int j=0; j<N; j++){
                    newList.add(sc.nextInt());
                }
                list.add(newList);
            }
            solution(list, N);
        }
    }

//    public static void main(String[] args) {
//        int[][] arr = {{1,0,0},{0,10,10},{0,10,10}};
//        System.out.println(getSum(arr, 0, 1));
//    }

    public static void solution(List<List<Integer>> list, int N){
        for (int k=0; k<N; k++){
            int m=0, n=0;
            long sum = Integer.MIN_VALUE;
            for (int i=0; i<list.size(); i++){
                for (int j=0; j<list.size(); j++){
                    int temp = getSum(list, i, j);
                    if (temp > sum){
                        sum = temp;
                        m = i;
                        n = j;
                    }
                }
            }
            for (int p=0; p<list.size(); p++){
                list.get(p).remove(n);
            }
            list.remove(m);
            System.out.println((m+1) + " " + (n+1));
        }
    }

    public static int getSum(List<List<Integer>> list, int i, int j){
        int sum = 0;
        for (int m=0; m<list.size(); m++){
            sum += list.get(i).get(m);
        }
        for (int m=0; m<list.size(); m++){
            sum += list.get(m).get(j);
        }
        sum -= list.get(i).get(j);
        return sum;
    }
}
