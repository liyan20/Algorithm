package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/11 07:38
 * @Title: 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [[1,2,3],
 *[4,5,6],
 * [7,8,9]],
 * 原地旋转输入矩阵，使其变为:
 * [[7,4,1],
 * [8,5,2],
 * [9,6,3]]
 * @Description: 根据分析，旋转的方法是转置（沿对角线翻转），然后对每一行翻转
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question011_0511_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i+1;j++){      //这里面要注意是小于i+1，这样就只交换一半的数据，
                if(i!=j){              //如果不这样的话，最后会交换然后又给换回去
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }



}
