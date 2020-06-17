package NowcoderAlgorithm_Part1_1.class06;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/14 12:37
 * @Title&Description: 最小生成树的Kruskal算法
 * 最小生成树是指的一个无向图里面，每条边有权重。我们想要将所有的点都联通，并且要求边的权值和最小。
 * @Analysis:
 * 方法：按照边的weight从小到大排列，来到一条边甲，甲的两边的结点，如果两个结点是在一个集合里面，就打×不考虑
 * 如果不在一个集合里面，就打√考虑，并把两个结点连在一起，两个结点的所在集合合并，保存这条边
 *
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_Kruskal {
    //这个类的算法不是很快，后面会有更快的并查集算法
    public static class MySet{
        //内部存放每个结点所属的集合
        public HashMap<Node, List<Node>> setMap;
        //针对每个结点，初始的时候就是一个结点一个集合，把每个结点放入集合中，并将结点-所属集合的信息存入hashmap
        public MySet(HashMap<Integer, Node> nodes){
            for (Node node : nodes.values()){
                List<Node> list = new ArrayList<>();
                list.add(node);
                setMap.put(node, list);
            }
        }

        //判断两个结点是不是同属一个集合
        public boolean isSameSet(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        //合并两个结点所在的集合为同一个集合，是两个集合的合并
        public void union(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            //针对每个toSet里面的结点，把结点放入fromSet里面，并且更新hashmap的toSet结点的集合信息
            //这样之后就是两个集合合并，是to集合合并到from集合里面去
            for (Node toNode : toSet){
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    //kruskal最小生成树算法
    public static Set<Edge> kruskalMST(Graph graph){
        //新建集合类
        MySet mySet = new MySet(graph.nodes);
        //新建优先级队列，小根堆，按照edge的weight排列
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        //将图的边放入小根堆
        for (Edge edge : graph.edges){
            priorityQueue.offer(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            //如果边上的两个结点不是一个集合，那么就加入结果，并且将两个集合合并union
            if (!mySet.isSameSet(edge.from, edge.to)){
                result.add(edge);
                mySet.union(edge.from, edge.to);
            }
        }
        return result;
    }

}
