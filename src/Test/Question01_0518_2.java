////package cn.wxz.Test;
////
////import java.util.HashSet;
////import java.util.*;
////
/////**
//// * @Author: xianz
//// * @Date: 2020/5/19 14:47
//// * @Title&Description:
//// * @Analysis:
//// * @ThinkingSteps:
//// * @TimeConsuming:
//// */
////
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        //给定root节点还有所需的treecode
//        CategoryTreeNode<T> root;
//        String code;
//        //找到所需的节点，建立一个list保存叶子节点
//        CategoryTreeNode<T> node = findNodePos(root, code);
//        List<CategoryTreeNode<T>> leaveList = new ArrayList<>();
//        findLeave(node, leaveList);
//        System.out.println(leaveList);
//
//    }
//
//    public static CategoryTreeNode<T> findNodePos(CategoryTreeNode<T> node, String code){
//        if(node == null){
//            return null;
//        }
//        //如果找到了对应的treecode，返回这个节点
//        if(node.nodeObj.treeCode == code){
//            return node;
//        }
//        //如果没有找到，子节点是一个list，遍历list元素，递归查找子节点是不是这个code
//        if(node.nodeObj.treeCode != code){
//            for(CategoryTreeNode<T> tempNode:node.childNodes){
//                CategoryTreeNode<T> temp = findNodePos(tempNode, code);
//                if(tempNode.nodeObj.treeCode == code){
//                    return tempNode;
//                }
//            }
//        }
//        return null;
//    }
//    public static CategoryTreeNode<T> findNodePos(CategoryTreeNode<T> node, String code){
//        if(node == null){
//            return null;
//        }
//        if(node.nodeObj.treeCode == code){
//            return node;
//        }
//        if(node.nodeObj.treeCode != code){
//            for(CategoryTreeNode<T> tempNode:node.childNodes){
//                return findNodePos(tempNode, code);
//            }
//        }
//        return null;
//    }
//
//    public static void findLeave(CategoryTreeNode<T> node,List<CategoryTreeNode<T>> leaveList){
//        if(node == null){
//            return;
//        }
//        if (node.childNodes == null) {
//            leaveList.add(node);
//            return ;
//        } else {
//            for (CategoryTreeNode<T> tempNode:node.childNodes) {
//                findLeave(tempNode,leaveList);
//            }
//        }
//    }
//}
//
//class CategoryTreeNode{
//
//}