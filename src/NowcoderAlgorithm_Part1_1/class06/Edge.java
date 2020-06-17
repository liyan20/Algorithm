package NowcoderAlgorithm_Part1_1.class06;

/**
 * @Author: xianz
 * @Date: 2020/6/13 09:14
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Edge {
    public int weight;  //边上的权重
    //边从哪到哪的
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
