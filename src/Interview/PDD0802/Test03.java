package Interview.PDD0802;

/**
 * @Author: xianz
 * @Date: 2020/8/2 19:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int yummy = sc.nextInt();
            List<int[]> midList = new ArrayList<>();
            for (int i=0; i<N; i++){
                midList.add(new int[] {sc.nextInt(), sc.nextInt()});
            }
            List<int[]> nightList = new ArrayList<>();
            for (int i=0; i<M; i++){
                nightList.add(new int[] {sc.nextInt(), sc.nextInt()});
            }
            System.out.println(getMinHeat(midList, nightList, yummy));
        }
    }

//    public static void main(String[] args) {
//        List<int[]> midList = new ArrayList<>();
//        List<int[]> nightList = new ArrayList<>();
//        int yummy = 1;
//        midList.add(new int[] {3,1});
//        nightList.add(new int[] {2,1});
//        System.out.println(getMinHeat(midList, nightList, yummy));
//    }

    //返回最小的热量
    //0和1分别代表热量和美味值。
    public static int getMinHeat(List<int[]> midList, List<int[]> nightList, int yummy){
        if (yummy == 0){
            return 0;
        }
        midList.add(new int[] {0,0});
        nightList.add(new int[] {0,0});
        Collections.sort(midList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Collections.sort(nightList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int minHeat = Integer.MAX_VALUE;
        for (int[] curMidMeal : midList){
//            curYummy += curMidMeal[1];
//            curHeat += curMidMeal[0];
            if (curMidMeal[1] >= yummy){
                minHeat = Math.min(minHeat, curMidMeal[0]);
                continue;
            }
            for (int[] curNightMeal :nightList){
                int curYummy = curMidMeal[1] + curNightMeal[1];
                int curHeat = curMidMeal[0] + curNightMeal[0];
                if (curYummy >= yummy){
                    minHeat = Math.min(minHeat, curHeat);
                }else {
                    break;
                }
            }
        }
        return minHeat == Integer.MAX_VALUE ? -1 : minHeat;
    }

//    public static int process(List<int[]> midList, List<int[]> nightList, int restYummy){
//        if (restYummy <= 0){
//            return 0;
//        }
//        //递归函数里面应该是可以选择午饭也可以选择晚饭也可以都不选也可以只选一个
//        int min = Integer.MAX_VALUE;
//
//        for (int i=0; i<midList.size(); i++){
//            int[] curMidMeal = midList.get(i);
//            for (int j=0; j<nightList.size(); j++){
//                int[] curNightMeal = nightList.get(j);
//                int res1 = process(midList, nightList, restYummy - curMidMeal[1]) + curMidMeal[0];
//                int res2 = process(midList, nightList, restYummy - curNightMeal[1]) + curNightMeal[0];
//            }
//
//        }
//        for (int j=0; j<nightList.size(); j++){
//
//        }
//        min =
//    }

}
