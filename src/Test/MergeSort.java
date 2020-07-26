package Test;

/**
 * @Author: xianz
 * @Date: 2020/7/21 20:39
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,5,586,345,36,75};
        for(int temp : arr){
            System.out.print(temp + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length-1);
        for(int temp : arr){
            System.out.print(temp + " ");
        }
    }

    //归并排序递归主方法
    public static void mergeSort(int[] nums, int L, int R){
        //base case。如果相等就是数组只有一个数时直接返回。因为是取中位数并且是mid和mid+1的分开
        //所以不存在L>R的情况发生。
        if (nums == null || nums.length < 1){
            return;
        }
        if (L == R){
            return;
        }
        //取中间值的高级方法，避免L和R相加越界，并且右移运算效率高。需要注意右移要加括号因为其优先级低于加法
        int mid = L + ((R - L) >> 1);
        //进行两次分别归并
        mergeSort(nums, L, mid);
        mergeSort(nums, mid+1, R);
        merge(nums, L, mid, R);  //归并完后得到排好序的两个数组，进行组合起来。
    }

    //对两个排好序的数组的组合过程
    public static void merge(int[] nums, int L, int mid, int R){
        //新建临时数组，保存组合后的值。
        int[] temp = new int[R-L+1];
        int p1 = L, p2 = mid+1;  //p1和p2分布代表左右数组的起点
        int i = 0;  //i代表组合临时数组的索引
        //左右两个数组谁小谁放进去，直到一个数组放完为止
        while (p1 <= mid && p2 <= R){
            temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        //下面两个循环是哪个没放完，接着放进去
        while (p1 <= mid){
            temp[i++] = nums[p1++];
        }
        while (p2 <= R){
            temp[i++] = nums[p2++];
        }
        //把临时数组的值传给一开始的数组，数组merge过程结束
        for (int j=0; j<temp.length; j++){
            nums[L+j] = temp[j];
        }
    }
}
