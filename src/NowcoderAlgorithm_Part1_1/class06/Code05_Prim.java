package NowcoderAlgorithm_Part1_1.class06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/15 15:48
 * @Title&Description: 最小生成树prim算法
 * 一开始选一个点，是任选，然后从这一个点，得到一堆边，在这一堆边里面选一个weight最小的边，加入result
 * 这样就得到了另一个点，也得到了这个点的一堆边，把目前所有的边，选一个最小的，加入result
 * 又得到一个点，又得到一堆边，把他们一起选一个最小的。一直下去。
 * 其中，如果边的权值最小，但是如果边的那头的结点已经在result里面的边的两边存在了，就下一个
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code05_Prim {
    public static Set<Edge> primMST(Graph graph){
        //小根堆存放边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        Set<Node> set = new HashSet<>();  //存放已经进入result的边的点
        Set<Edge> result = new HashSet<>();  //存放最终结果的边

        //任选一个点，用完就break
        for (Node node : graph.nodes.values()){
            //把任选的那个点放进去，还有把这个结点的所有的边都放进去
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges){
                    priorityQueue.offer(edge);
                }
            }
            while (!priorityQueue.isEmpty()){
                Edge edge = priorityQueue.poll();  //解锁最小的边
                Node toNode = edge.to;  //可能的一个新的结点
                //如果不含有的时候，就是新的结点。之后把新结点放入set，这个边也可以存入result里面
                if (!set.contains(toNode)){
                    set.add(toNode);
                    //这里面木有加判断边是否重复的代码，所以要把边的加入放入这个if里面去
                    result.add(edge);
                    //再把当前点的边全放进去
                    for (Edge nextEdge : toNode.edges){
                        priorityQueue.offer(nextEdge);
                    }
                }
            }
            break;
        }
        return result;
    }
}
