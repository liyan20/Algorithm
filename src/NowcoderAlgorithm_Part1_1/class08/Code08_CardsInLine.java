package NowcoderAlgorithm_Part1_1.class08;

/**
 * @Author: xianz
 * @Date: 2020/6/22 10:00
 * @Title&Description: 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code08_CardsInLine {
    public static void main(String[] args) {
        int[] arr = {1,100,2,5,6,7,2,45,547,235,34};
        System.out.println(win1(arr));
    }

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //因为先手拿牌和后手拿牌都有可能取得最大值，所以求max
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    //f方法代表在arr[i, j]上面拿牌，我是先手的最大值
    public static int f(int[] arr, int i, int j){
        //如果只剩下一张牌，我是先手，怎么办，那就拿走这张牌呗
        if (i == j){
            return arr[i];
        }
        //如果还有牌，我可以选择两边的，就有两种可能，分别是选择i位置的牌和j位置的牌
        //然后加上剩下的结果，这个剩下的是后手那个人的结果，我只需要得到两种情况下的最大值就行
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    //s方法代表在arr[i, j]上面拿牌，我是后手的最大值
    public static int s(int[] arr, int i, int j) {
        //如果只剩下一张牌，我是后手，因为两个人都是绝对聪明，所以这一张牌肯定是被先手拿走，我后手只能是0
        if (i == j){
            return 0;
        }
        //我是后手，先手很聪明，所以他肯定只会给我留下最小的那个结果，所以是min
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}
