package NowcoderAlgorithm_Part1_1.class06;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/13 10:32
 * @Title&Description: 宽度优先遍历
 * 主要方法是维护一个队列和一个HashSet，set的作用是防止重复的结点进去
 * 第一个结点入队。之后出队并打印，然后把还没有入对的当前结点的nexts结点入队。
 * 这样就保证，从第一个结点开始，先打印离他最近的，最近的可能有好几个，这个顺序无所谓。然后打印理他距离为2的
 * 这样顺序下去，是为宽度优先遍历BFS，即为Breadth First Search
 * 注：set的重要作用：
 * 如果是无向图，即两个点之间的边是互相连接的，那么两个点的nexts结点都是对方，如果没有set的话，会无限重复下去
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_BFS {
    public static List<Node> bfs(Node node){
        List<Node> list = new ArrayList<>();
        if (node == null){
            return list;
        }
        Deque<Node> queue = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();
        queue.offerLast(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.pollFirst();
            list.add(cur);
            //对于当前结点的所有直接后继，如果不在set里面，入队入set
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    queue.offerLast(next);
                    set.add(next);
                }
            }
        }
        return list;
    }

}
