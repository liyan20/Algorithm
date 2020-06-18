package NowcoderAlgorithm_Part1_1.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xianz
 * @Date: 2020/6/18 09:36
 * @Title&Description: 输入： 正数数组costs 正数数组profits 正数k 正数m
 * 含义： costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你只能串行的最多做k个项目 m表示你初始的资金
 * 说明： 你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。 输出： 你最后获得的最大钱数。
 * @Analysis:
 * 方法：先把所有的按照花费放入小根堆。然后根据目前的钱数，把所有小于钱数的项目放入一个按照利润排序的大根堆
 * 之后对大根堆出队，把利润加到钱数上面去。接着下一轮的弹出小根堆放入大根堆的过程
 *
 * 这个就相当于，打游戏时候打怪，肯定是只能打比自己弱的怪，然后每个怪有收益，那肯定是打收益最大的怪
 * @Summary:
 * 使用优先级队列的时候必须要定义比较器，因为默认是return 0就是啥也不干
 *
 * 建立局部最优标准，把每个样本按照局部最优标准逐个考虑，这就是贪心。至于局部最优怎么想，平时练习去
 * @TimeConsuming:
 */
public class Code05_IPO {
    //这个是每个项目的类，p代表利润，c代表花费
    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    //可以做最多k个项目，启动资金是W，下面两个是利润和花费
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Cost){
        //新建以花费的小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });
        //新建以利润的大根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.p - o1.p;
            }
        });
        for (int i=0; i<Profits.length; i++){
            minCostQ.offer(new Node(Profits[i], Cost[i]));
        }
        for (int i=0; i<k; i++){
            //当小根堆不为空并且花费比目前的资金少的话，就把资项目从小根堆出来放入大根堆
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W){
                maxProfitQ.offer(minCostQ.poll());
            }
            //如果大根堆空了，就直接返回W
            if (maxProfitQ.isEmpty()){
                return W;
            }
            //如果大根堆有东西，就选择大根堆利润最大的拿出来做，把利润直接加到当前本金里面去
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
