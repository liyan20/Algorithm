package Coding_Interviews;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/6/18 20:02
 * @Title&Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * @Analysis:
 * 分类是DFS，向下找有没有这个字符串
 * @Summary:
 * @TimeConsuming:
 */
public class Code65_HasPath {
    public static class Node{
        public char val;
        public List<Node> nexts;
        public boolean isUsed;

        public Node(char val) {
            this.val = val;
            this.nexts = new ArrayList<>();
            this.isUsed = false;
        }
    }

    public static class Graph{
        public List<Node> nodes;

        public Graph() {
            this.nodes = new ArrayList<>();
        }
    }

    public static Graph graphGenerator(char[] matrix, int rows, int cols){
        Graph graph = new Graph();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                graph.nodes.add(new Node(matrix[i * cols + j]));
            }
        }
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                Node curNode = graph.nodes.get(i * cols + j);
                if ((i * cols + j + 1) >= 0 && (i * cols + j + 1) < rows * cols){
                    curNode.nexts.add(graph.nodes.get(i * cols + j + 1));
                }
                if ((i * cols + j - 1) >= 0 && (i * cols + j - 1) < rows * cols){
                    curNode.nexts.add(graph.nodes.get(i * cols + j - 1));
                }
                if (((i + 1) * cols + j) >= 0 && ((i + 1) * cols + j) < rows * cols){
                    curNode.nexts.add(graph.nodes.get((i + 1) * cols + j));
                }
                if (((i - 1) * cols + j) >= 0 && ((i - 1) * cols + j) < rows * cols){
                    curNode.nexts.add(graph.nodes.get((i - 1) * cols + j));
                }
            }
        }
        return graph;

    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || rows < 0 || cols < 0 || str == null || str.length < 1){
            return false;
        }
        Graph graph = graphGenerator(matrix, rows, cols);
        Deque<Node> stack = new ArrayDeque<>();
        boolean flag = false;
        int times = 0;
        for (int i=0; i<rows * cols; i++){
            if (graph.nodes.get(i).val != str[0]){
                continue;
            }
            char[] result = new char[str.length];
            stack.offerFirst(graph.nodes.get(i));
            graph.nodes.get(i).isUsed = true;
            result[0] = graph.nodes.get(i).val;
            times = 1;

            //这个可能是hashset的问题，进入过之后我出来换个路径，结果里面得已经有了，但我其实不想要他有
            //边界条件有问题，结束的条件。
            while (times < str.length && !stack.isEmpty()){
                Node cur = stack.pollFirst();
                cur.isUsed = false;
                times--;
                for (Node next : cur.nexts){
                    if (next.val == str[times+1] && !next.isUsed){
                        stack.offerFirst(cur);
                        cur.isUsed = true;
                        stack.offerFirst(next);
                        next.isUsed = true;
                        result[++times] = next.val;
                        times ++;
                        break;
                    }
                }
            }
            if (isEqual(result, str)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isEqual(char[] arr1, char[] arr2){
        for (int i=0; i<arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
//        char[] str = {'b','c','c','e','d'};
        char[] str = "ABCCED".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
