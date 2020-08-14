package Interview.YFD;

/**
 * @Author: xianz
 * @Date: 2020/8/1 20:02
 * @Title&Description:
 * 感觉是一个图的入度出度的问题
 * 每个点可以得到从何处来的点
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test02 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int N = sc.nextInt();
//            List<int[]> list = new ArrayList<>();
//            for (int i=0; i<N; i++){
//                int[] arr = new int[2];
//                arr[0] = sc.nextInt();
//                arr[1] = sc.nextInt() - 2;
//                list.add(arr);
//            }
//            System.out.println(maxNum(list));
//        }
//    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {2,-2});
        list.add(new int[] {1,0});
        list.add(new int[] {-1,0});
//        list.add(new int[] {3,2});
        System.out.println(maxNum(list));
    }

    public static int maxNum(List<int[]> list){
        //建立图模型进行保存node
        List<Node> nodeList = new ArrayList<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Node, Integer> inMap = new HashMap<>();  //保存来自谁的
        for (int i=0; i<list.size(); i++){
            int id = i;
            int value = list.get(i)[0];
            int fatherNum = list.get(i)[1];
            Node curNode = new Node(id, value, fatherNum);
            nodeList.add(curNode);
        }
        Node root = null;
        for (int i=0; i<nodeList.size(); i++){
            Node curNode = nodeList.get(i);
            if (curNode.fatherNum < 0){
                root = curNode;
            }else {
                Node fatherNode = nodeList.get(curNode.fatherNum);
                fatherNode.nexts.add(curNode);
            }
        }
        Node cur = root;
        int res = process(cur);
        return res;
    }

    public static int process(Node root){
        if (root.nexts.size() == 0){
            return root.value;
        }
        int res = 0;
        for (Node subNode : root.nexts){
            int value = process(subNode);
            if (value > 0){
                res += value;
            }
        }
        return root.value + res < 0 ? 0 : root.value + res;
    }

    //结点类
    public static class Node{
        public int id;
        public int value;
        public int fatherNum;
        public ArrayList<Node> nexts;

        public Node(int id, int value, int fatherNum) {
            this.id = id;
            this.value = value;
            this.fatherNum = fatherNum;
            nexts = new ArrayList<>();
        }
    }
}
