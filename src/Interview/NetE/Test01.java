package Interview.NetE;

/**
 * @Author: xianz
 * @Date: 2020/8/8 14:59
 * @Title&Description:
 * 计算一堆单词的出现频率，出现频率大于1%就是关键词，输出关键词数量
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] arr = new String[n];
            for (int i=0; i<n; i++){
                arr[i] = sc.nextLine();
            }
            System.out.println(keyWordsNum(arr));
        }
    }

    public static int keyWordsNum(String[] arr){
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            String cur = arr[i];
            if (!map.containsKey(cur)){
                map.put(cur, 1);
            }else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        int num = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if (value >= arr.length * 0.01){
                num++;
            }
        }
        return num;
    }
}
