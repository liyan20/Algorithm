package NowcoderAlgorithm_Part1_1.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xianz
 * @Date: 2020/6/18 09:13
 * @Title&Description:
 * 贪心策略的题目代码都很短
 * 通过某一个标准建立一个相对次序依次处理就结束了，不管是堆还是排序，都是按照自己确定的次序对样本进行处理之后再来搞的结构
 * 主要内容在于脑补这个次序是什么
 * @Analysis: 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板? 给一个数组，里面有要分成的长度
 * 方法：放入小根堆里面，一次取两个出来，加起来再放入堆，这个加起来的加到结果上去，然后再取两个，加起来再放回
 * 最终结果是最小的，目的其实是每次切成尽量相同的两块吧感觉
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_LessMoneySplitGold {
    public static int lessMoney(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i=0; i<arr.length; i++){
            priorityQueue.offer(arr[i]);
        }
        int result = 0;
        int cur = 0;
        //小根堆里面只剩下一个数的时候停止
        while (priorityQueue.size() > 1){
            cur = priorityQueue.poll() + priorityQueue.poll();
            result += cur;
            priorityQueue.offer(cur);
        }
        return result;
    }
}
