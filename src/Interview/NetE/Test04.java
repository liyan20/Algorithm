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
//        List<ListNode> list = new ArrayList<>();
//        for (int i=0; i<n; i++){
//            ListNode newNode = new ListNode(i+1);  //名字是1开始
//            list.add(newNode);
//        }
//        for (int i=0; i<m; i++){
//            int fromId = arr[i][0];
//            int toId = arr[i][1];
//            ListNode fromNode = list.get(fromId-1);
//            ListNode toNode = list.get(toId-1);
//            fromNode.nexts.add(toNode);
//        }
//        for (int i=0; i<list.size(); i++){
//
//        }
//
//    }
//
//    public static boolean isRelation(ListNode n1, ListNode n2){
//        if (n1.id == n2.id){
//            return true;
//        }
//        for (ListNode temp : n1.nexts){
//            return isRelation(temp, n2);
//        }
//        return false;
//    }
//
//    public static void isRelation(List<String> list, ListNode n1, ListNode n2){
//
//    }
//
//    public static class ListNode{
//        public int id;
//        public List<ListNode> nexts;
//
//        public ListNode(int id) {
//            this.id = id;
//            this.nexts = new ArrayList<>();
//        }
//    }
//}
