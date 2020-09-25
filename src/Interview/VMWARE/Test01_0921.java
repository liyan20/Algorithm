package Interview.VMWARE;

/**
 * @Author: xianz
 * @Date: 2020/9/21 20:28
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * 在做物理实验匀速运动问题的途中，小A遇到了如下计算上的困难，他决定让计算机来帮忙解决这一问题。
 *
 * 这个问题描述如下，小球在一个大小为n的正方形中绕着边界逆时针匀速走动。
 *
 * 假设球一开始坐标在（0,0）,正方形的四个角分别为(0,0),(n,0),(n,n),(0,n)。
 *
 * 现在，小球每走r个单位距离，就要记录下小球所在的坐标，一共需要记录m次。给出n,m,r,请你计算小球的位置。
 *
 *
 *
 * 输入描述
 * 输入包含三个数，n,m,r,中间以空格隔开，其中n,r可能为小数
 *
 * 1≤n,r≤2×107，m≤100
 *
 * 输出描述
 * 输出m行，每行两个小数空格隔开，保留2位（四舍五入），代表每一次记录的坐标。
 *
 *
 * 样例输入
 * 3 5 5
 * 样例输出
 * 3.00 2.00
 * 0.00 2.00
 * 3.00 0.00
 * 1.00 3.00
 * 1.00 0.00
 *
 * 提示
 * 样例输入2
 * 7495417.6435616808 10 6125201.7312234128
 *
 * 样例输出2
 * 6125201.73 0.00
 * 7495417.64 4754985.82
 * 4110647.74 7495417.64
 * 0.00 5480863.65
 * 644338.08 0.00
 * 6769539.81 0.00
 * 7495417.64 5399323.90
 * 3466309.66 7495417.64
 * 0.00 4836525.57
 * 1288676.16 0.00
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0921 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double n = sc.nextDouble();
            int m = sc.nextInt();
            double r = sc.nextDouble();
            solution(n, m, r);
        }
    }

    /**
     *
     * @param n 矩形长度
     * @param m 次数
     * @param r 每次走的长度
     */
    public static void solution(double n, int m, double r){
        double posX = 0, posY = 0;
        double length = r;
        if(r > n * 4){
            length = r % 4;
        }
        //输出m次
        for (int i=0; i<m; i++){
            if (length <= n){
                double[] p = process(length, n, posX, posY);
                posX = p[0];
                posY = p[1];
            }else if (length > n && length <= 2*n){
                double[] p1 = process(n, n, posX, posY);
                posX = p1[0];
                posY = p1[1];
                double[] p2 = process(length - n, n, posX, posY);
                posX = p2[0];
                posY = p2[1];
            }else if (length > 2 * n && length <= 3*n){
                double[] p1 = process(n, n, posX, posY);
                posX = p1[0];
                posY = p1[1];
                double[] p2 = process(length, n, posX, posY);
                posX = p2[0];
                posY = p2[1];
                double[] p3 = process(length - 2 * n, n, posX, posY);
                posX = p3[0];
                posY = p3[1];
            }else if (length > 3 * n && length <= 4*n){
                double[] p1 = process(n, n, posX, posY);
                posX = p1[0];
                posY = p1[1];
                double[] p2 = process(length, n, posX, posY);
                posX = p2[0];
                posY = p2[1];
                double[] p3 = process(length, n, posX, posY);
                posX = p3[0];
                posY = p3[1];
                double[] p4 = process(length - 3 * n, n, posX, posY);
                posX = p4[0];
                posY = p4[1];
            }
            System.out.println(String.format("%.2f %.2f", posX, posY));
//            System.out.println(posX + " " + posY);
        }
    }

    public static double[] process(double length, double n, double x, double y){
        if (x >= 0 && x <n && y == 0){  //在最下面那一行
            if (length <= n - x){
                x = x + length;
                y = y;
            }else {
                y = length - n + x;
                x = n;
            }
        }else if (x == n && y >= 0 && y < n){  //右边那一列
            if (length <= n - y){
                y = y + length;
                x = n;
            }else {
                x = 2 * n - y - length;
                y = n;
            }
        }else if (x > 0 && x <= n && y == n){  //上面那一行
            if (length <= x){
                x = x - length;
                y = y;
            }else {
                y = n - length + x;
                x = 0;
            }
        }else if (x == 0 && y > 0 && y <= n){  //右边那一列
            if (length <= y){
                y = y - length;
                x = x;
            }else {
                x = length - y;
                y = 0;
            }
        }
        return new double[] {x, y};
    }
}
