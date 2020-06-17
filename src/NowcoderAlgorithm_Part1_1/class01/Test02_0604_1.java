package NowcoderAlgorithm_Part1_1.class01;

/**
 * @Author: xianz
 * @Date: 2020/5/28 21:09
 * @Title&Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Analysis: 方法：从右上角开始判断。如果target小于当前数，那就在左边查找，如果是大于，那就在下面查找。
 * 因为对于每个数，左边都是小于他的，下面都是大于他的。其实也可以左下角，因为左下角来说，上面都是小于他的，右边都是
 * 大于他的
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Test02_0604_1 {
    public static void main(String[] args) {
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, a));

    }
    public static boolean Find(int target, int [][] array) {
        boolean flag = false;
        if(array==null){
            return false;
        }
        //右上角，是第一行和最后一列
        int row = 0;
        int col = array[0].length-1;
        while (row < array.length && col >= 0){
            if (target == array[row][col]){
                flag = true;
                break;
            }else if (target < array[row][col]){
                col--;
            }else if (target > array[row][col]){
                row++;
            }
        }
        return flag;
    }
}
