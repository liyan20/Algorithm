package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/18 09:05
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code04_FindNumberIn2DArray_0817 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        boolean flag = false;
        //双指针向上和向右搜索
        while(i >= 0 && j < matrix[0].length){
            int cur = matrix[i][j];
            if(cur > target){  //大于目标向上减少自己
                i--;
            }else if(cur < target){  //小于目标向右增加自己
                j++;
            }else{  //等于目标直接返回
                flag = true;
                break;
            }
        }
        return flag;
    }
}
