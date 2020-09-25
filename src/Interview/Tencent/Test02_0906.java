package Interview.Tencent;



/**
 * @Author: xianz
 * @Date: 2020/9/6 20:02
 * @Title&Description:
 * 一行n和m，代表n个人和m个团队
 * 下面m行，第一个数是有x个人，之后是代表团队人员的编号
 * 先通知编号为0的人，之后这个0号会通知他所在的，之后是会通知其他的
 *
 *
 *输入
 * 50 5
 * 2 1 2
 * 5 10 11 12 13 14
 * 2 0 1
 * 2 49 2
 * 4 6 7 8 2
 *输出
 * 7
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0906 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Set<Integer>> lists = new ArrayList<>();
            for (int i=0; i<m; i++){
                Set<Integer> temp = new HashSet<>();
                int x = sc.nextInt();  //当前团队几个人
                for (int j=0; j<x; j++){
                    temp.add(sc.nextInt());
                }
                lists.add(temp);
            }
            solution(lists);
        }
    }

    public static void solution(List<Set<Integer>> lists){
        //将0与0有关系的元素全部获取到
        Set<Integer> zeroSet = new HashSet<>();
        for (Set<Integer> temp : lists){
            if (temp.contains(0)){
                zeroSet.addAll(temp);
            }
        }

        //放入并查集里面
        Map<Integer, Set<Integer>> setMap = new HashMap<>();
        for (Set<Integer> set : lists){
            for (int temp : set){
                setMap.put(temp, set);
            }
        }
        for (Map.Entry entry : setMap.entrySet()){
            int key = (int)entry.getKey();
            Set<Integer> set = (Set<Integer>)entry.getValue();

        }

        for (Set<Integer> set : lists){
            for (int i : set){
                if (zeroSet.contains(i)){
                    zeroSet.addAll(set);
                    break;
                }
            }
        }
        System.out.println(zeroSet.size());
    }

    public static boolean isSameSet(int a, int b, Map<Integer, Set<Integer>> setMap){
        return setMap.get(a) == setMap.get(b);
    }

    public static void union(int a, int b, Map<Integer, Set<Integer>> setMap){
        Set<Integer> list1 = setMap.get(a);
        Set<Integer> list2 = setMap.get(b);
        for (int temp : list2){
            list1.add(temp);
            setMap.put(b, list1);
        }
    }
}
