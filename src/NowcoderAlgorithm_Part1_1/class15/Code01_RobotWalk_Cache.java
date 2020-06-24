package NowcoderAlgorithm_Part1_1.class15;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/24 17:06
 * @Title&Description: 还是机器人那题
 * 使用记忆化搜索的方法
 * 使用一个傻cache，每次遇到递归先看缓存里面有没有，有的话直接返回。没有的话
 * 在下面方法内部的return里面先给放进去
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_RobotWalk_Cache {
    public static void main(String[] args) {
        System.out.println(walkCache(5,2,3,3));
    }

    public static int walkCache(int N, int start, int K, int P){
        if (N < 2 || K < 1 || start < 1 || start > N || P < 1 || P > N){
            return 0;
        }
        //当cur和rest却确定了之后，递归函数的返回值也确定了，所以才可以使用cache保存
        Map<String, Integer> cache = new HashMap<>();
        return walk(N, start, K, P, cache);
    }

    //N代表多少个位置，P代表最终要到哪个位置，cur代表现在到哪了，rest代表还有多少步可以走
    //这个rest其实就是代表了K的隐含在里面
    public static int walk(int N, int cur, int rest, int P, Map<String, Integer> cache){
        //先根据当前的递归参数得到key，查找是否在cache里面，是的话返回
        String key = String.valueOf(cur) + "_" + String.valueOf(rest);
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        //res参数用来保存进cache里面
        int res = 0;
        //如果走完了所有的步数
        if (rest == 0){
            //如果当前位置到了P，那么返回1说明存在这一种路径，如果不是在P，说明
            //这条路上走完了所有的步数还没到指定的位置，是无效的路径，所以是0
            //用res保存结果，放入cache里面，下面每一个return都是这样
            res = cur == P ? 1 : 0;
            cache.put(key, res);
            return res;
        }

        //下面就是没走完步数

        //如果在位置1上面，只能往右走
        if (cur == 1){
            res = walk(N, 2, rest - 1, P, cache);
            cache.put(key, res);
            return res;
        }
        //如果在N位置上，只能往左走
        if (cur == N){
            res = walk(N, N - 1, rest - 1, P, cache);
            cache.put(key, res);
            return res;
        }
        //来到这一步的时候，说明没走完步数，并且目前在中间位置，那就可以往左可以往右两种情况
        res = walk(N, cur + 1, rest - 1, P, cache) + walk(N, cur - 1, rest - 1, P, cache);
        cache.put(key, res);
        return res;
    }
}
