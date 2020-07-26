package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/21 21:03
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,5,586,345,36,75};
        for(int temp : arr){
            System.out.print(temp + " ");
        }
        System.out.println();
        sortArray(arr);
        for(int temp : arr){
            System.out.print(temp + " ");
        }
    }

    public static int[] sortArray(int[] nums){
        if (nums == null || nums.length < 1){
            return new int[0];
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int L, int R){
        //大于的情况是等于p的区间已经在最后了，就越界，可以返回
        //等于的情况是等于区间右边就是R，也不用排序直接返回
        if (L >= R){
            return;
        }
        //随机选择一个数和最后一位数交换，因为partition是以最后一位数作为p进行比较的
        swap(nums, L + (int)(Math.random() * (R - L + 1)), R);
        int[] p = partition(nums, L, R);
        quickSort(nums, L, p[0] - 1);
        quickSort(nums, p[1] + 1, R);
    }

    //partition过程是把小于p的放在数组左边，等于p的放中间，大于p的放右边
    //返回的是等于区域的范围。
    public static int[] partition(int[] nums, int L, int R){
        //以最后一个数作为荷兰国旗的判断条件
        int p = nums[R];
        //less代表的是小于部分的起点，more代表的是大于部分的起点
        int less = L - 1;
        int more = R+1;
        int i = L;
        while (i < more){
            if (nums[i] < p){
                //把less下一位和i交换，排到中间的时候，less的下一位其实就是小于等于p的。
                //如果less和i相差一位，那就是小于p，如果是相差大于一位，那less下一位就是等于p的
                //所以可以直接交换，因为交换了要不然是相差一位，自己交换自己，要不然是和
                //等于p的第一位进行交换，less前进一位，等于p前进一位而已。
                swap(nums, i++, ++less);
            }else if (nums[i] > p){
                //这里面和大于的交换了和more的前一位进行交换。
                //这个流程下来，能够保证小于等于less的是小于p的，less+1到i-1的是等于p的
                //大于等于more到右边界是大于p的，但是i到more是不确定的，所以大于的交换之后i不会前进，
                // 因为要判断新来的数的情况
                swap(nums, i, --more);
            }else {
                i++;
            }
        }
        //之前的方法是最后一个数还没有处理，和more的第一位交换就行，同时More前进一位
        //我这边直接不用这个方法，我就是连同最后一个一起判断交换就完事了
//        swap(nums, more++, R);

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
