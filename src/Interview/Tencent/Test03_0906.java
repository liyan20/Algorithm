package Interview.Tencent;



/**
 * @Author: xianz
 * @Date: 2020/9/6 20:02
 * @Title&Description:
 * 一行n和k，代表n个字符串和K个数
 * 下面n行，N个字符串
 *
 * 判断字符串出现次数。分别输出前K大和前K小
 *想法：
 * 先判断词频，之后是按照词频和字典序进行排序就行
 *
 *输入
4 2
1
2
3
4
 *输出
1 1
2 1
1 1
2 1
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;

public class Test03_0906 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            int n = Integer.valueOf(s1.split(" ")[0]);
            int k = Integer.valueOf(s1.split(" ")[1]);
            String[] arr = new String[n];
            for (int i=0; i<arr.length; i++){
                arr[i] = sc.nextLine();
            }
            solution(arr, k);
        }
    }

    public static void solution(String[] arr, int k){
        //词频统计
        Map<String, Integer> map = new HashMap();
        for (int i=0; i<arr.length; i++){
            String cur = arr[i];
            if (!map.containsKey(cur)){
                map.put(cur, 1);
            }else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        //最多的k个字符串
        PriorityQueue<String> maxQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))){
                    return getCompare(o1, o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });
        for (Map.Entry entry : map.entrySet()){
            String key = (String) entry.getKey();
            int value = (int)entry.getValue();
            maxQueue.offer(key);
        }
        for (int i=0; i<k; i++){
            String cur = maxQueue.poll();
            System.out.println(cur + " " + map.get(cur));
        }

        //最少的k个字符串
        PriorityQueue<String> minQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))){
                    return getCompare(o1, o2);
                }
                return map.get(o1) - map.get(o2);
            }
        });
        for (Map.Entry entry : map.entrySet()){
            String key = (String) entry.getKey();
            int value = (int)entry.getValue();
            minQueue.offer(key);
        }
        for (int i=0; i<k; i++){
            String cur = minQueue.poll();
            System.out.println(cur + " " + map.get(cur));
        }
    }

    public static int getCompare(String o1, String o2){
        int len = Math.min(o1.length(), o2.length());
        for (int i=0; i<len; i++){
            char c1 = o1.charAt(i);
            char c2 = o2.charAt(i);
            if (c1 < c2){
                return -1;
            }else if (c1 > c2){
                return 1;
            }
        }
        return o1.length() < o2.length() ? -1 : 1;
    }

}
