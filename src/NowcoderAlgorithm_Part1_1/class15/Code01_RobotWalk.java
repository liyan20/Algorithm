package NowcoderAlgorithm_Part1_1.class15;

/**
 * @Author: xianz
 * @Date: 2020/6/24 11:22
 * @Title&Description: 机 器人达到指定位置方法数
 * 【题目】 假设有排成一行的 N 个位置，记为 1~N，N 一定大于或等于 2。
 * 开始时机器人在其中的 M 位 置上(M 一定是 1~N 中的一个)，机器人可以往左走或者往右走，
 * 如果机器人来到 1 位置， 那 么下一步只能往右来到 2 位置;如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置。
 * 规定机器人必须走 K 步，最终能来到 P 位置(P 也一定是 1~N 中的一个)的方法有多少种。
 * 给 定四个参数 N、M、K、P，返回方法数。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_RobotWalk {
    public static void main(String[] args) {
        System.out.println(walkWays(5,2,3,3));
    }

    public static int walkWays(int N, int M, int K, int P){
        return walk(N, M, K, P);
    }
    //N代表多少个位置，P代表最终要到哪个位置，cur代表现在到哪了，rest代表还有多少步可以走
    //这个rest其实就是代表了K的隐含在里面
    public static int walk(int N, int cur, int rest, int P){
        //如果走完了所有的步数
        if (rest == 0){
            //如果当前位置到了P，那么返回1说明存在这一种路径，如果不是在P，说明
            //这条路上走完了所有的步数还没到指定的位置，是无效的路径，所以是0
            return cur == P ? 1 : 0;
        }

        //下面就是没走完步数

        //如果在位置1上面，只能往右走
        if (cur == 1){
            return walk(N, 2, rest - 1, P);
        }
        //如果在N位置上，只能往左走
        if (cur == N){
            return walk(N, N - 1, rest - 1, P);
        }
        //来到这一步的时候，说明没走完步数，并且目前在中间位置，那就可以往左可以往右两种情况
        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }
}
