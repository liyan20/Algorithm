package NowcoderAlgorithm_Part1_1.class06;

/**
 * @Author: xianz
 * @Date: 2020/6/13 09:30
 * @Title&Description: 将二阶矩阵的输入变成我们自己的Graph结构
 * 1.从输入的矩阵中获取信息：边的weight，两个结点的value
 * 2.把两个结点放入图的nodes hashmap中，编号也是结点的value
 * 3.把两个结点和边拿出来，边新建好就已经完善好信息了，把边放入图中
 * 对两个结点更新信息：
 * 结点：value, in, out, nexts, edges。针对from和to两个结点分别更新所需的信息。
 * fromNode是out, nexts, edges；toNode是in。
 * 边：weights, from, to。边新建完就是更新完了。
 * @Analysis:
 * 设计自己的图模板。遇到题目时候，最好能够只写接口就可以写算法
 * @Summary:
 * @TimeConsuming:
 */
public class GraphGenerator {
    //输入是一个matrix，N*3的二阶矩阵，每一行是三个数，代表[边的weight，from结点的值，to结点的值]
    public static Graph createGraph(int[][] matrix){
        //新建一个Graph
        Graph graph = new Graph();
        for (int i=0; i<matrix.length; i++){  //针对每一行，即每个边的信息
            //每一行代表着一条边，边两边的两个点
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            //我们把结点的值也当成其编号，放入Graph的nodes结点集合中。
            //因为可能边里面是连接的重复的点，所以先判断是否放入
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            //下面把两个结点，还有边给新建出来，完善结点和边本身的信息
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);  //边是新建的，边的信息已经完成

            //结点的信息有in,out,nexts,edges，下面开始完善
            //from的结点因为是边是从他出去的，所以nexts和edges和out都要加
            fromNode.nexts.add(toNode);
            fromNode.out++;
            fromNode.edges.add(newEdge);
            //to结点是被进入的，所以只要in需要更新
            toNode.in++;

            //最后把Graph的边信息更新
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
