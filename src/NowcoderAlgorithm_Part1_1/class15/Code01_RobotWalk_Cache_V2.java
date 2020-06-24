package NowcoderAlgorithm_Part1_1.class15;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/24 17:16
 * @Title&Description:
 * 记忆化搜索的第二个版本
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_RobotWalk_Cache_V2 {
    public static void main(String[] args) {
        System.out.println(walkCache2(5,2,3,3));
    }

    public static int walkCache2(int N, int start, int K, int P){
        if (N < 2 || K < 1 || start < 1 || start > N || P < 1 || P > N){
            return 0;
        }
        //递归函数的参数里面只有cur和rest是变量，另外的N和P是常量，所以主要的参数是(cur, rest)
        //cur的范围是1-N，rest的范围是0-K，所以可以使用数组来替换hashmap。并且两个变量是有范围的
        int[][] cache = new int[N+1][K+1];
        return walk2(N, start, K, P, cache);
    }



    public static int walk2(int N, int cur, int rest, int P, int[][] cache){
        String key = String.valueOf(cur) + "_" + String.valueOf(rest);
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        int res = 0;
        if (rest == 0){
            res = cur == P ? 1 : 0;
            cache.put(key, res);
            return res;
        }

        if (cur == 1){
            res = walk2(N, 2, rest - 1, P, cache);
            cache.put(key, res);
            return res;
        }
        if (cur == N){
            res = walk2(N, N - 1, rest - 1, P, cache);
            cache.put(key, res);
            return res;
        }
        res = walk2(N, cur + 1, rest - 1, P, cache) + walk2(N, cur - 1, rest - 1, P, cache);
        cache.put(key, res);
        return res;
    }
}
