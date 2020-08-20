package SortAlgorithm;

/**
 * @Author: xianz
 * @Date: 2020/8/14 09:58
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class QuickSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right){
        //大于的情况是等于p的区间已经在最后了，就越界，可以返回
        //等于的情况是等于区间右边就是R，也不用排序直接返回
        if (left >= right){
            return;
        }
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(arr, randomIndex, right);  //随机选择一个数和最后一位数交换，因为partition是以最后一位数作为p进行比较的
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0]-1);
        quickSort(arr, p[1]+1, right);
    }

    //partition过程是把小于p的放在数组左边，等于p的放中间，大于p的放右边
    //返回的是等于区域的范围。
    public static int[] partition(int[] arr, int left, int right){
        //less代表的是小于部分的起点，more代表的是大于部分的起点
        int less = left - 1;
        int more = right + 1;
        int index = left;
        int p = arr[right];  //以最后一个数作为荷兰国旗的判断条件

        while (index < more){
            if (arr[index] < p){
                //把less的下一位和i交换，排到中间的时候，less的下一位其实就是小于等于p的。
                //如果less和i相差一位，那就是小于p，如果是相差大于一位，那less下一位就是等于p的
                //所以可以直接交换，因为交换了要不然是相差一位，自己交换自己，要不然是和
                //等于p的第一位进行交换，less前进一位，等于p前进一位而已。
                swap(arr, index++, ++less);
            }else if (arr[index] > p){
                //这里面和大于的交换了和more的前一位进行交换。
                //这个流程下来，能够保证小于等于less的是小于p的，less+1到i-1的是等于p的
                //大于等于more到右边界是大于p的，但是i到more是不确定的，所以大于的交换之后i不会前进，
                // 因为要判断新来的数的情况
                swap(arr, index, --more);
            }else {
                index++;
            }
        }
        //最终的less是小于区域的最后一位，more是大于区域的第一位
        return new int[] {less+1, more-1};
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
