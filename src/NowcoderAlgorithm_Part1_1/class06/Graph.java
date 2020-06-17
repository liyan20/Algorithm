package NowcoderAlgorithm_Part1_1.class06;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: xianz
 * @Date: 2020/6/13 09:20
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Graph {
    //编号和其对应的点
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;  //边界的集合

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
