package huawei.huaweiTest1;

/**
 * @Author: xianz
 * @Date: 2020/5/12 08:38
 * @Title: 删数
 * @Description: 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
 * ｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 * 输入例子1:
 * 8
 * 输出例子1:
 * 6
 * @Analysis: 关于里面是+2，是因为每次删除操作之后，当前的数没了，所以index指向的数变成了下一个，所以本来应该是+3的变成了+2
 * 其次，+2之后，就是正常的index%size了，缩小也没事
 * @ThinkingSteps:
 * @TimeConsuming: 20min
 */
import java.util.*;
public class Test01_0512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Solution(n);
        }
    }
    public static void Solution(int n){
        if(n>1000){
            n = 999;
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int curIndex = 0;
        int deleteIndex = 0;
        while (list.size()>1){
            deleteIndex = (curIndex+2) % list.size();
            list.remove(deleteIndex);
            curIndex = deleteIndex;
        }
        System.out.println(list.get(0));
    }
}
