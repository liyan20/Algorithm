package Interview.GSX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/8/7 19:47
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0807 {
    public static void main(String[] args) {
        Node n10 = new Node(0);
        Node n20 = new Node(0);
        Node n1 = n10;
        Node n2 = n20;
        n1.next = new Node(1);
        n1 = n1.next;
        n1.next = new Node(1);
        n1 = n1.next;
        n1.next = new Node(1);
        n1 = n1.next;
    }

    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node mergeTwoLists(Node n1, Node n2){
        if (n1 == null || n2 == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        while (n1 != null){
            list.add(n1);
            n1 = n1.next;
        }
        while (n2 != null){
            list.add(n2);
            n2 = n2.next;
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        Node dummy = new Node(0);
        Node cur = dummy;
        for (int i=0; i<list.size(); i++){
            cur.next = list.get(i);
            cur = cur.next;
        }
        return dummy.next;
    }

}
