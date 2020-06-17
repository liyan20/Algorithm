package NowcoderAlgorithm_Part1_1.class04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: xianz
 * @Date: 2020/6/11 20:25
 * @Title&Description: 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，
 * 每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 * 输入描述:
 * 每组数据一行一个数字，为题目中的n(n小于等于1000)。
 * 输出描述:
 * 一行输出最后剩下的数字。
 * 示例1
 * 输入
 * 500
 * 输出
 * 255
 * @Analysis: 主要方法是维护一个长度为n的数组，和一个List
 * 先把数组奇数位置置-1，然后把不是-1的放进list，再把list里面的传到数组前面的位置，记录当前位置
 * 然后是遍历0到那个位置，就是不是-1的即为上次保存下来的数字。再来一遍。直到list的size<=1,退出循环
 * @Summary:
 * @TimeConsuming:
 */
import java.util.*;
public class Test03_0611_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(removeOddNum(n));
        }
    }

    public static int removeOddNum(int N){
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        //把数据放入数组
        for (int i=0; i<N; i++){
            arr[i] = i;
            list.add(i);
        }
        int length = N;
        while (list.size() > 1){
            //清除奇数位的数字，变成-1
            for (int i=0; i<length; i++){
                if ((i + 1) % 2 == 1){
                    arr[i] = -1;
                }
            }
            list.clear();  //清空list
            //不能把判断条件放在循环体里面，因为这个是循环条件，如果是！=-1为条件，遇到第一个不是-1的就退出了
            for (int i=1; i<arr.length; i++){
                //把不是-1的放入list
                if (arr[i] != -1){
                    list.add(arr[i]);
                }
            }
            //把list里面的放回数组前面位置，其他位置置-1
            for (int i=0; i<arr.length; i++){
                arr[i] = -1;
                if (i < list.size()){
                    arr[i] = list.get(i);
                }
            }
            //数组有效长度变成list的大小
            length = list.size();
        }
        return list.get(0);
    }
}
