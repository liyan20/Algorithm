package NowcoderAlgorithm_Part1_1.class06;

import java.util.ArrayList;

/**
 * @Author: xianz
 * @Date: 2020/6/13 09:13
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Node {
    public int value;  //结点的值
    public int in;  //连向这个结点的边的个数
    public int out;  //从这个结点发散出去的边的个数
    public ArrayList<Node> nexts;  //从这个点发散出去的边连向了哪些点的集合
    public ArrayList<Edge> edges;  //从这个结点发散出去的边的结合

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
