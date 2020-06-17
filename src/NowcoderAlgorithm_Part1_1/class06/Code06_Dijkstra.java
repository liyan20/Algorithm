package NowcoderAlgorithm_Part1_1.class06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xianz
 * @Date: 2020/6/15 16:58
 * @Title&Description: 单源最短路径，Dijkstra算法 /dikstra/这么读，音标不会打
 * 单源最短路径是指的，在一个图里面，给定一个结点，要求这个结点到其他结点的最短路径
 * 返回是一个list，包含到各个结点的最短路径长度，可以是hashmap来保存
 *
 * 这个和最小生成树的区别是最小生成树要求是所有点连在一起的时候总的边是最短的
 * 单源最短路径是指的是指定结点到其他结点的路径是最短的
 * @Analysis:
 * 方法是先从指定点开始，一开始定义给定点A到其他结点距离是正无穷。
 * 然后，从A开始，有几条边通往其他的点，判断A到这些点的距离，更新（和之前的最小距离比较取最小值）
 * 之后A的所有边判断完毕了，A不管了。下面判断的结点是所有的最短路径里面的最小的那个结点。
 * 假设是B，把B拿过来，B的当前最小值是之前A在的时候更新的那个路径最小值，然后B出发有很多边
 * 把这些边拿来计算从B开始的边的点的最短路径，这个是要计算边的weight加上B的最短路径，因为这个是代表
 * 从A到B再到其他点的最短距离，和当前其他结点的最短距离比较，保存最小值
 * @Summary:
 * @TimeConsuming:
 */
public class Code06_Dijkstra {
    public static Map<Node, Integer> dijkstra1(Node head){
        //distanceMap这个表key是图里面的结点，value是从给定的head结点到那个点的最短路径长度
        Map<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);  //先把head到head的距离放进去，毫无疑问是0

        //这个set代表的是已经摸过的点，即已经处理完得到最短路径的点，之后再也不会碰这些点
        Set<Node> selectedNodes = new HashSet<>();
        //找到当前路径最小的那个点，一开始肯定是就是head自己啦
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        //minNode为空的时候就是所有的结点都被找过的时候
        while (minNode != null){
            int distance = distanceMap.get(minNode);  //当前结点的最短路径
            //开始处理结点的所有发散的边
            for (Edge edge : minNode.edges){
                Node toNode = edge.to;  //边的另一头的结点
                //如果hashmap木有包含，其实就是是无穷大的情况，放进去。距离是from结点的最短路径和这个结点的weight之和
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(minNode, distance + edge.weight);
                }else {
                    //如果包含了，比较大小取最小的
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);  //结点的边处理完了之后，这个结点就处理完了
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);  //进行下一个结点的处理
        }
        return distanceMap;
    }

    //这个方法是在一个结点已经找到最短路径处理结束之后，在后面的结点中找到目前的路径长度最短的点
    //并且要保证是不重复的，即不能把已经找过的又找一遍
    public static Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distanceMap, Set<Node> touchedNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
