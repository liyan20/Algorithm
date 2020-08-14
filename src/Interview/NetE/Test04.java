//package Interview.NetE;
//
///**
// * @Author: xianz
// * @Date: 2020/8/8 15:45
// * @Title&Description:
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//
//import java.util.*;
//public class Test04 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] arr = new int[m][2];
//            for (int i=0; i<arr.length; i++){
//                arr[i][0] = sc.nextInt();
//                arr[i][1] = sc.nextInt();
//            }
//
//            System.out.println(4);
//        }
//    }
//
//    public static int relationNum(int n, int m, int[][] arr){
//        List<Node> list = new ArrayList<>();
//        for (int i=0; i<n; i++){
//            Node newNode = new Node(i+1);  //名字是1开始
//            list.add(newNode);
//        }
//        for (int i=0; i<m; i++){
//            int fromId = arr[i][0];
//            int toId = arr[i][1];
//            Node fromNode = list.get(fromId-1);
//            Node toNode = list.get(toId-1);
//            fromNode.nexts.add(toNode);
//        }
//        for (int i=0; i<list.size(); i++){
//
//        }
//
//    }
//
//    public static boolean isRelation(Node n1, Node n2){
//        if (n1.id == n2.id){
//            return true;
//        }
//        for (Node temp : n1.nexts){
//            return isRelation(temp, n2);
//        }
//        return false;
//    }
//
//    public static void isRelation(List<String> list, Node n1, Node n2){
//
//    }
//
//    public static class Node{
//        public int id;
//        public List<Node> nexts;
//
//        public Node(int id) {
//            this.id = id;
//            this.nexts = new ArrayList<>();
//        }
//    }
//}
