package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/7/13 21:17
 * @Title&Description: 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 * @Analysis:
 * 这里面有一个F代表第几层会碎是固定的，但是我们不知道。我们要保证最坏情况下扔鸡蛋的次数最少。
 * 即这个F有可能是1-N的任一层，而不管是哪层，我们都要保证扔的次数不超过我们要求的那个结果。
 * 比如一个鸡蛋两层，如果F是1，那么第一层扔了就碎了，就能得到F是1。如果F是2，那么第一层没碎，那肯定就是F是2，
 * 所以最多需要仍2次，就能得到这个F。这个意思
 * 如果没碎，那么就是楼层+1，鸡蛋-1的子问题+1，后面1代表尝试次数。
 * 如果碎了，那就是楼层-1，鸡蛋-1的子问题+1。
 * @Summary:
 * @TimeConsuming:
 */
public class Code887_SuperEggDrop_0713_3 {
    public int superEggDrop(int K, int N) {
        return 0;
    }

//    //递归函数。
//    public static int process(){
//
//    }
}