package NowcoderAlgorithm_Part1_1.class08;

/**
 * @Author: xianz
 * @Date: 2020/6/22 09:25
 * @Title&Description: 背包问题
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物 品不能超过这个重量。返回你能装下最多的价值是多少？
 * @Analysis:
 * 直接递归，不考虑动态规划
 * 这也是个从左往右依次考虑的问题，每件物品可以考虑要也可以不要
 * @Summary:
 * @TimeConsuming:
 */
public class Code07_Knapsack {
    public static int getMaxValue(int[] w, int[] v, int bag){
        if (w == null || v == null || bag < 0){
            return 0;
        }
        return process(w, v, 0, 0, bag);
    }

    //w和v分别代表质量和价值数组，index代表当前到第几个物体了，alreadyW代表当前的重量，bag代表总重量
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag){
        //当前的重量超过总重量了，说明这个装法不行。这个必须是-1而不是0，因为要判断是否可行，如果是0直接相加
        //那么下面判断每次都要加上当前的，是不对的
        if (alreadyW > bag){
            return -1;
        }
        //如果index已经到头了，说明没得装了啊。并且index应该是从0开始的，如果到了w.length这边，说明越界了
        if (index == w.length){
            return 0;
        }
        //这个是不用当前物品的情况，直接index+1，alreadyW没变
        int p1 = process(w, v, index + 1, alreadyW, bag);
        //如果要当前货物价值，那么总价值 = 当前货物的价值 + 后续货物的价值
        //这个p2Next就是后续货物的价值，之所以单独拿出来，是因为不一定后续货物价值是有效的，有可能直接超了呢
        //这里面这么判断，减少了判断的难度，当然也可以直接判断是否超重啦
        int p2Next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = Integer.MIN_VALUE;
        //如果不是-1，说明有效，可以加起来
        if (p2Next != -1){
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }
}
