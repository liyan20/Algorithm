//package Test.vivo0607;
//
///**
// * @Author: xianz
// * @Date: 2020/6/7 15:54
// * @Title&Description:
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//import java.util.*;
//public class Test03_0607_2 {
//    public static List<String> lines = new ArrayList<>();
//    public static void main(String[] args) {
//
//
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(System.in);
//            while (scanner.hasNextLine()) {
//                List<String> list = new ArrayList<>();
//                List<ListNode> Nodelist = new ArrayList<>();
//                int num = Integer.valueOf(scanner.nextLine());
//                for (int i=0; i<num; i++){
//                    list.add(scanner.nextLine());
//                }
//                Nodelist = solution();
//            }
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//
//        // TODO output
//
//    }
//
//    static class ListNode {
//        int val;
//
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//
//    private static ListNode mergeNodes(ListNode head ) {
//
//    }
//
//    public static List<ListNode> solution(List<String> list){
//        int num = list.size();
//        List<ListNode> nodeList = new ArrayList<>();
//        for (int i=0; i<num; i++){
//            String[] cur = list.get(i).split(" ");
//            for (int j=0; i<cur.length; j++){
//                nodeList.add(new ListNode(Integer.valueOf(cur[j])));
//            }
//        }
//        Collections.sort(nodeList, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        for (int i=0; i<nodeList.size()-1; i++){
//            nodeList.get(i).next = nodeList.get(i+1);
//        }
//        return nodeList;
//    }
//}
