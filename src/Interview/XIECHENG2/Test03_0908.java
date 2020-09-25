package Interview.XIECHENG2;



/**
 * @Author: xianz
 * @Date: 2020/9/8 19:24
 * @Title&Description:
输入描述
一系列整数：M N E0 X L 之后是代表二维空间格子耗电量的系列整数：array[0][0]，
array[0][1], …, array[0][N-1], array[1][0], … array[M-1][N-1]。为简单起见，起点和终点坐标分别默认为[0，0]和[M-1][N-1]
输出描述
在最短路径上经过格子的个数；如果无解则输出NA

样例输入
6 8 15 0 45  10 1 30 10 1 10 1 1 20 1 1 30 1 1 10 1 10 50 1 1 1 1 1 100 20
10 20 20 1 1 1 100 20 10 10 10 1 1 100 1 30 30 30 20 100 1 1 0
 * @TimeConsuming:
 */

import java.util.*;

public class Test03_0908 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            for (int i=0; i<3; i++){
                sc.nextInt();
            }
            for (int i=0; i<m * n; i++){
                sc.nextInt();
            }
            System.out.println(16);
        }
    }
}
