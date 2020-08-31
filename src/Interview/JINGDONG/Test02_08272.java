package Interview.JINGDONG;

/**
 * @Author: xianz
 * @Date: 2020/8/27 19:39
 * @Title&Description: 有一个初始长度为0的数列，现在对其实施以下三种操作：
 * (1) 插入某一个元素；
 * (2) 将某一个元素删除；
 * (3) 查询当前数列的状态（输出数列中每一个元素的值）。
 * 输入描述
 * 单组输入。
 * 第1行一个正整数m表示一共有m个操作。
 * 接下来m行表示m个操作，每行输入的第1个数字为op（操作类型）。
 * 如果op=1表示第(1)种操作，后面接着两个数字a和b分别表示在第a个位置插入b（a以及a以后的数字将后移）。
 * 如果op=2表示第(2)种操作，后面接着一个数字a，表示删除第a个数字。
 * 如果op=3表示第(3)种操作，查询当前数列的状态。
 * （m<=1000，输入操作保证合法。）
 * 输出描述
 * 对于每一个op=3，输出当前数列的状态（输出数列中每一个元素的值）。
 * 样例输入
 * 3
 * 1 1 3
 * 1 2 4
 * 3
 * 样例输出
 * 3 4
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */



import java.util.*;
public class Test02_08272 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = Integer.valueOf(sc.nextLine());
            String[] arr = new String[m];
            for (int i=0; i<m; i++){
                arr[i] = sc.nextLine();
            }
            if (m != 0){
                solution(arr);
            }else {
                System.out.println();
            }

        }
    }

    public static void solution(String[] arr){
        Node dummy = new Node(0);
        for (int i=0; i<arr.length; i++){
            String[] opArr = arr[i].split(" ");
            int op = Integer.valueOf(opArr[0]);
            if (op == 1){
                insert(dummy, Integer.valueOf(opArr[1]), Integer.valueOf(opArr[2]));
            }else if (op == 2){
                delete(dummy, Integer.valueOf(opArr[1]));
            }else if (op == 3){
                show(dummy);
            }
        }
        return;
    }

    public static void show(Node dummy){
        Node temp = dummy;
        StringBuilder sb = new StringBuilder();
        temp = temp.next;
        while (temp != null){
            sb.append(temp.val);
            temp = temp.next;
            sb.append(" ");
        }
        if (sb.length() >= 1){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }

    public static void delete(Node dummy, int index){
        int i = 0;
        Node temp = dummy;
        while (i != index - 1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public static void insert(Node dummy, int index, int val){
        Node node = new Node(val);
        Node temp = dummy;
        int i = 0;
        while (i != index-1){
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

}
