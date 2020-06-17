package NowcoderAlgorithm_Part1_1.class02;

/**
 * @Author: xianz
 * @Date: 2020/5/30 19:19
 * @Title&Description: 快速排序
 * 1.0版本：
 * 使用partition方法，令p为数组最后一个数。将数组从0到倒数第二个数，就是不管最后一个数，
 * 小于等于的放在左边，大于的放在右边。之后把最后一个数和大于区域的第一个交换。
 * 这样保证当前的数是排在他应该的位置，而左边的都是小于等于的，右边都是大于的。
 * 之后对这个数左边的和右边的，进行递归，就可以了
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code06_QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,1,5,7,4,5,586,345,1,2,4,36,754,4,3,3};
        quick_1_0(arr, 0, arr.length-1);
        for(int temp : arr){
            System.out.println(temp);
        }
    }

    //这是荷兰国旗问题的简化版，小于等于和大于
    public static void quick_1_0(int[] arr, int L, int R){
        if(L < R){
            int p = arr[R];
            int less = L - 1;
            int index = L;
            //这里面是针对[L..R-1]来处理的
            while (index < R){
                if(arr[index] <= p){
                    swap(arr, index++, ++less);
                }else {
                    index++;
                }
            }
            //这段有问题，index应该是大于区的第一个元素，而不是小于等于区的后一个，因为可能就没有大于区
            index = less + 1;
            swap(arr, index, R);
            quick_1_0(arr, L, index-1);
            quick_1_0(arr, index+1, R);
        }
    }



    //这个之前的写法有一个问题，如果是两个数是相等的，那么就直接为0了。加个判断
    public static void swap(int[] arr, int i, int j){
        if(arr[i] != arr[j]){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
