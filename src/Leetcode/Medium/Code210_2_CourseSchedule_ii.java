package Leetcode.Medium;

/**
 * @Author: xianz
 * @Date: 2020/6/14 09:59
 * @Title&Description: 拓扑排序
 * 这次试试不写那么多左神的图结构了，只保留我们需要的结点的in
 * 稍微快了那么一点点
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Code210_2_CourseSchedule_ii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //返回空数组
        if (numCourses == 0 || prerequisites == null){
            return new int[0];
        }
        List<Node> list = new ArrayList<>();
        Graph graph = graphGenerator(numCourses, prerequisites);
        Map<Node, Integer> inMap = new HashMap<>();
        Deque<Node> zeroInQueue = new ArrayDeque<>();
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.offerLast(node);
            }
        }
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.pollFirst();
            list.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    zeroInQueue.offerLast(next);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++){
            result[i] = list.get(i).value;
        }
        return list.size() == numCourses ? result : new int[0];
    }


    public static Graph graphGenerator(int numCourses, int[][] prerequisites){
        Graph graph = new Graph();
        //这里面修改一下，不是按照二阶矩阵放入图，因为可能有的结点是孤立的，所以按照数量放入
        for (int i=0; i<numCourses; i++){
            graph.nodes.put(i, new Node(i));
        }
        //这个是按照二阶矩阵完善结点和边的信息
        for (int i=0; i<prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.nexts.add(toNode);
            toNode.in++;
        }
        return graph;
    }

    public static class Node{
        public int value;
        public int in;
        public ArrayList<Node> nexts;

        public Node(int value) {
            this.value = value;
            in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static class Graph{
        public HashMap<Integer, Node> nodes;
        public Graph(){
            nodes = new HashMap<>();
        }
    }

}
