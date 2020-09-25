package Leetcode.Search_DynamicPrograming;

/**
 * @Author: xianz
 * @Date: 2020/9/1 15:06
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code17_24_GetMaxMatrix_0901 {

    public static void main(String[] args) {
        int[][] matrix = {{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}};
        int[] res = getMaxMatrix(matrix);

        for (int i : res){
            System.out.println(i);
        }
    }

    /**
     * 这边是计算矩阵的最大和。
     * @param matrix
     * @return
     */
    public static int[] getMaxMatrix(int[][] matrix) {
        int left1 = 0,left2 = 0,right1 = 0,right2 = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            int[] tempArr = new int[matrix[0].length];
            for(int j=i; j<matrix.length; j++){  //j也是从i开始加，表示是可以只选一行
                //这边是计算累加和
                for(int k=0; k<matrix[0].length; k++){
                    tempArr[k] += matrix[j][k];
                }
                int[] p = maxSum(tempArr);
                if(max < p[2]){
                    max = p[2];  //这个一开始忘记加上去了
                    left1 = i;
                    left2 = j;
                    right1 = p[0];
                    right2 = p[1];
                }
            }
        }
        return new int[] {left1, right1, left2, right2};
    }

    /**
     * 这个是最大子序和的代码。要求子数组必须是连续的。
     * @param nums
     * @return
     */
    public static int[] maxSum(int[] nums){
        //tempLeft代表暂时的left，每次等到最大值更新的时候，更新真正的left值
        int left = 0, right = 0, cur = 0, tempLeft = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            cur = cur + nums[i];
            if (cur > max){
                max = cur;
                left = tempLeft;
                right = i;
            }
            if (cur < 0){
                tempLeft = i+1;
                cur = 0;
            }
        }
        //返回最大值的左右坐标和最大值
        return new int[] {left, right, max};
    }
}
