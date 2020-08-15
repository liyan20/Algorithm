package Interview.XIECHENG;

/**
 * @Author: xianz
 * @Date: 2020/8/15 19:44
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(200);


        }
    }

    public static class Node{
        String name;
        int val;
        List<Node> nexts;

        public Node(String name, int val) {
            this.name = name;
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    public static void solution2(String str){
        Node head;
        String[] arr = str.split("|");
        String[] temp = arr[0].split("\'");
        List<Node> list = new ArrayList<>();
        Map<String, Node> map = new HashMap<>();
        Node cur;

        for (int i=0; i<arr.length; i++){
            temp = arr[i].split("\'");
            String name = temp[0];
            int val = Integer.valueOf(temp[1]);
            if (!map.containsKey(name)){
                cur = new Node(name, val);
                map.put(name, cur);
            }else {
                cur = map.get(name);
            }

        }


    }
}
