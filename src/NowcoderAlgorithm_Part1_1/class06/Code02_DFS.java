package NowcoderAlgorithm_Part1_1.class06;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/13 11:07
 * @Title&Description: 深度优先遍历
 * 流程：一条路走到死，走不下去了往上退，看还有没有其他的支路的点之前没走过，一直退到开头，就结束了。
 * 维护一个栈和一个set
 * 第一个结点入栈，入栈的时候打印，这个是经典DFS的方法
 * 之后当前结点cur出栈，对当前结点cur的nexts结点集合，如果直接后继还没有放入过set的，把当前结点cur还有其那个后继结点
 * 都入栈，先入cur，再入那个后继并打印然后break！！！不管其他的后继了，进行下一轮循环。
 * 注意点：
 * 1.入栈的时候打印
 * 2.存在没有在set的后继节点时，要把当前结点和后继都入栈，因为我们后面break了，当前结点还有没遍历完的后继
 *
 * 这个方法主要是按照深度走一个支路，把这条路的结点都放入set，这个使得一条路走到死，然后往后退的时候，不会走已经走过的点
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code02_DFS {
    public static List<Node> dfs(Node node){
        List<Node> list = new ArrayList<>();
        if (node == null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();
        stack.offerFirst(node);
        set.add(node);
        list.add(node);
        while (!stack.isEmpty()){
            Node cur = stack.pollFirst();
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    stack.offerFirst(cur);
                    stack.offerFirst(next);
                    set.add(next);
                    list.add(next);
                    break;
                }
            }
        }
        return list;
    }
}
