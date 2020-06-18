package NowcoderAlgorithm_Part1_1.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xianz
 * @Date: 2020/6/18 10:34
 * @Title&Description: 快速在数据流中查找中位数，数据流就是数据是一次一次给的，给完之后可能还能再加几个数据这种
 * 方法：定义一个大根堆和小根堆，每个放n/2的数据。大根堆放小于中位数的数据，小根堆放大于中位数的数据，这样取两个堆的头就行了
 * 步骤：
 * 1.一个数，如果大根堆是空的，先放到大根堆。
 * 2.一个数如果<=大根堆的堆顶，放入大根堆，否则放入小根堆
 * 3.如果两个堆的size差值大于1，就把多的那个堆的堆顶放入另一个堆
 * 第三步的可行性分析：因为左边是小的部分的大根堆，右边是大的部分的小根堆，而两个堆的堆顶之间都是相差的非常小的，就是
 * 目前的数据流的相邻的数。所以哪个多了放到另一个，只不过是在加入的那个堆的堆顶添加了一个数罢了。不会影响整体的效果。
 * 相当于之前不平衡的时候，两个堆是在三分之一处切开放两个堆里面得，现在变成的是按照二分之一的位置切开防止，这样就可以得到
 * 真正的中位数
 * @Analysis:
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * @Summary:
 * @TimeConsuming:
 */
public class Code06_MedianQuick {

    //这是定义的也是题目要求的求中位数的一个结构
    public static class MedianFinder{
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //这是在如果两个堆差值等于2的时候调换数据。谁大把大的堆顶拿出来给另一个
        private void modifyTwoHeapsSize(){
            if (this.maxHeap.size() == this.minHeap.size() + 2){
                this.minHeap.offer(this.maxHeap.poll());
            }
            if (this.minHeap.size() == this.maxHeap.size() + 2){
                this.maxHeap.offer(this.minHeap.poll());
            }

        }

        //插入数据。小于左边的大根堆或者大根堆为空时放入大根堆，否则放入小根堆，保证左边大根堆都是小的
        //右边小根堆都是大的
        public void addNum(int num){
            if (maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }
            modifyTwoHeapsSize();
        }

        //查找中位数。如果是奇数，说明两个堆不一样大，那么中位数就是大的那个的堆顶。如果是偶数说明是一样大的堆
        //把两个堆顶相加除以二
        public double findMedian(){
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            if (maxHeapSize + minHeapSize == 0){
                return 0;
            }
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();
            if (maxHeapSize == minHeapSize){
                return (maxHeapHead + minHeapHead) / 2.0;   //这边要除以2.0保证是double类型，要不然会出错
            }
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }
    }
}
