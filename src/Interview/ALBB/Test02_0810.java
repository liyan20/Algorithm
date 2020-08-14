//package Interview.ALBB;
//
//import java.util.Scanner;
//
///**
// * @Author: xianz
// * @Date: 2020/8/10 19:31
// * @Title&Description:
// * @Analysis:
// * @Summary:
// * @TimeConsuming:
// */
//import java.util.*;
//public class Test02_0810 {
//    public static class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode parent;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc=  new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[] arr = new int[n-1];
//            for (int i=0; i<arr.length; i++){
//                arr[i] = sc.nextInt();
//            }
//            int[][] posArr = new int[m][2];
//            for (int i=0; i<m; i++){
//                posArr[i][0] = sc.nextInt();
//                posArr[i][1] = sc.nextInt();
//            }
//
//
//        }
//    }
//
////    public static void main(String[] args) {
////        int[] arr = {1,1,2,4};
////        int[][] posArr = {{2,3},{2,1},{4,3}};
////    }
//
//    public static TreeNode geneTree(int n, int[] arr, Map<Integer, TreeNode> map){
//        TreeNode head = new TreeNode(1);
//        TreeNode dummy = head;
//
//        for (int i=0; i<arr.length; i++){
//            TreeNode cur = new TreeNode(i+2);
//            cur.parent =
//        }
//
//    }
//}
