package Leetcode.Medium;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/14 10:07
 * @Title&Description: 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * @Analysis: 就是判断有没有环的，我用拓扑排序做的
 * @Summary:
 * @TimeConsuming:
 */
public class Code207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //返回空数组
        if (numCourses == 0 || prerequisites == null){
            return false;
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
        //这里面是判断最终入队并且出队的入度为0的结点是不是等于课程数，如果等于说明是可以的，如果不等于，说明有某些结点
        //始终没有进入队列，就是说他们的入度始终没有等于0，说明是非有向无环图
        return list.size() == numCourses;
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
            Edge newEdge = new Edge(1, fromNode, toNode);
            graph.edges.add(newEdge);

            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            toNode.in++;
        }
        return graph;
    }

    public static class Node{
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }
    public static class Edge{
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
    public static class Graph{
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph(){
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }
}
