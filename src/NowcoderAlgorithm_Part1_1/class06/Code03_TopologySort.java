package NowcoderAlgorithm_Part1_1.class06;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/14 08:43
 * @Title&Description: 拓扑排序
 * 拓扑排序是指的是图中一些结点之间有先后的依赖关系，按照依赖的先后顺序找到结点
 * 举个例子，比如写代码时候的依赖包，这个就是拓扑排序，一个文件依赖另一个，另一个文件依赖另一个这种，就需要根据拓扑排序
 * 找到最需要先加载的包，这种
 * 拓扑排序的条件：1.有向无环图。因为如果是无向图就是相当于互相依赖，那么不知道是谁先谁后。如果有环的话，也不知道是谁先谁后
 * 2.有结点入度为0。其实只要保证无环，总有结点入度为0
 * @Analysis:
 * 方法：先找到入度为0的结点，然后将从其擦除影响，然后找下一个入度为0的结点，一直找就行了
 * @Summary:
 * @TimeConsuming:
 */
public class Code03_TopologySort {
    public static void main(String[] args) {

    }

    public static List<Node> sortedTopology(Graph graph){
        List<Node> result = new ArrayList<>();
        //map用来存放每个结点当前的入度in
        //队列用来记录入度为0的结点
        Map<Node, Integer> inMap = new HashMap<>();
        Deque<Node> zeroInQueue = new ArrayDeque<>();
        //把所有结点的入度存入hashmap，并把第一个入度为0的结点放入队列
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.offerLast(node);
            }
        }
        while (!zeroInQueue.isEmpty()){
            //出队即为入度为0的，放入result数组里面
            Node cur = zeroInQueue.pollFirst();
            result.add(cur);
            //针对当前结点的后继
            for (Node next : cur.nexts){
                //消除当前结点的影响，就是当前结点的直接相邻的点的入度-1就行了
                //相当于是把这个点以及这个点的边都给擦掉，表现上就是这个点的相邻的点来自这个点的边都给擦掉了
                //就是相当于入度-1
                inMap.put(next, inMap.get(next) - 1);
                //把相邻点的入度为0的再放入队列
                if (inMap.get(next) == 0){
                    zeroInQueue.offerLast(next);
                }
            }
        }
        return result;
    }
}
