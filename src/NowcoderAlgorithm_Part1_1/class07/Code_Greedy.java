package NowcoderAlgorithm_Part1_1.class07;

/**
 * @Author: xianz
 * @Date: 2020/6/17 15:21
 * @Title&Description: 贪心算法
 * 在某一个标准下，优先考虑最满足标准的样本，最后考虑最不满足标准的样本，最终得到 一个答案的算法，叫作贪心算法。
 * 也就是说，不从整体最优上加以考虑，所做出的是在某种意义上的局部最优解。
 * 局部最优  -?->  整体最优
 *
 * 即我们选一个局部最优解，在一个或者两个样本的时候是最优解，就按照这个来，最终可能全局最优。
 * 至于是否全局最优需要严格的证明，但是证明很难，左神说笔试时候不要证明
 *
 *贪心算法的在笔试时的解题套路
 * 1，实现一个不依靠贪心策略的解法X，可以用最暴力的尝试
 * 2，脑补出贪心策略A、贪心策略B、贪心策略C...
 * 3，用解法X和对数器，去验证每一个贪心策略，用实验的方式得知哪个贪心策略正确
 * 4，不要去纠结贪心策略的证明
 *
 * 总的来说，你觉得这种方法可行，干就完了。比如会议室开会，会议有开始时间和结束时间，让你选怎么让开的会最多。
 * 有几种想法，一个是按照开始时间安排；按照持续时间安排；按照结束时间安排
 * 正确答案是按照结束时间安排，可以整个对数器
 *
 * 对数器：给定最大数组长度，最大值，使用Math.random()方法，获得小于这个最大值的随机数，获得随机的数值
 * 就可以得到一个随机的数组了
 * @Analysis:
 * 建立局部最优标准，把每个样本按照局部最优标准逐个考虑，这就是贪心。至于局部最优怎么想，平时练习去
 * 贪心策略的题目代码都很短
 * 通过某一个标准建立一个相对次序依次处理就结束了，不管是堆还是排序，都是按照自己确定的次序对样本进行处理之后再来搞的结构
 * 主要内容在于脑补这个次序是什么
 *
 * 贪心算法大量用到排序和堆，在又放回的贪心时候用堆
 * @Summary:
 * @TimeConsuming:
 */
public class Code_Greedy {
    //生成随机数组，随机有限长度和随机有限最大值的数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test复制数组，用于可能使得数组内容变化的情况
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test判断数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //我们的方法和绝对正确的方法，比如纯粹暴力求可能的排列组合
    public static void solution1(int[] arr){
    }
    public static void solution2(int[] arr){
    }
    public static void printArray(int[] arr){
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            //处理两个数组
            solution1(arr1);
            solution2(arr2);
            //如果两个方法的结果不一样，打印出来哪里不一样的
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
