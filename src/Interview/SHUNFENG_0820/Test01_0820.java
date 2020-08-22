package Interview.SHUNFENG_0820;

/**
 * @Author: xianz
 * @Date: 2020/8/20 20:34
 * @Title&Description:
 * 服务器管理
 * 小A的购买了一批服务器，他准备将这些服务器租用出去。每一个服务器有一个固定的带宽，
 * 人们根据自己需要的带宽来租用这些服务器。一台服务器只能租给一个人。
 *
 * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。有m个客户来租服务器，
 * 第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。
 * （服务器带宽独立不可叠加，若不能成功租出则输出0） 小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
 * 输入描述
 * 输入第一行包含两个数n,m
 * 接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小。
 * 接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
 * n,m≤1000 , 1≤ai,bi,ci≤1000
 * 输出描述
 * 输出一个数，即小A最多能租多少元的服务器出去。
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0820 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] capi = new int[n];
            for (int i=0; i<n; i++){
                capi[i] = sc.nextInt();
            }
            int[][] arr = new int[m][2];
            for (int i=0; i<m; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            System.out.println(solution(n, m, capi, arr));
        }
    }

    /**
     * 获得最大的收益
     * 设计到服务器的分配。要分配和合适的人，并且要保证收益最大
     * @param n
     * @param m
     * @param capi
     * @return
     */
    public static int solution(int n, int m, int[] capi, int[][] arr){
        Arrays.sort(arr, new Comparator<Object>(){
            @Override
            public int compare(Object oo1, Object oo2) {
                int[] o1 = (int[])oo1;
                int[] o2 = (int[])oo2;
                if (o1[0] < o2[0]){
                    return -1;
                }else if (o1[0] > o2[0]){
                    return 1;
                }else {
                    return o2[1] - o1[1];
                }
            }
        });
        Arrays.sort(capi);
        //我觉得应该是按照顺序来判断，按照需求的顺序来。
        //最终我应该是想要把所有的服务器都用完的。
        int sum = 0;
        //根据服务器来进行判断
        int index = 0;
        int[] mostGain = new int[n];
        for (int i=0; i<n; i++){
            int cur = 0;
            while (index < m && arr[index][0] <= capi[i]){
                cur = Math.max(cur, arr[index][1]);
                index++;
            }
            mostGain[i] = cur;
        }
        for (int temp : mostGain){
            sum += temp;
        }
        return sum;
    }
}
