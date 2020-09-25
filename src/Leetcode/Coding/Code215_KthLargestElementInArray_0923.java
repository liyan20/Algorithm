package Leetcode.Coding;

/**
 * @Author: xianz
 * @Date: 2020/9/23 11:07
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code215_KthLargestElementInArray_0923 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        return solutionTopK(nums, k);
    }

    /**
     * 求数组中TopK的最小值。因为leetcode有这道题，所以可以判断对不对
     * 使用大根堆即可
     * @param arr 要处理的数组，很大不能用排序
     * @param k 最大的K个数
     * @return 返回长度为K的数组
     */
    public static int solutionTopK(int[] arr, int k){
        if (k <= 0){
            return 0;
        }
        int heapSize = k;
        int[] heapArr = new int[k];
        //建立小根堆
        //每次的heapify可以保证当前的index到最后是保持一个堆的结构的。所以使用heapify要倒着来
        for (int i=k-1; i>=0; i--){
            heapArr[i] = arr[i];
            heapify(heapArr, i, heapSize);
        }
        //开始判断，如果小于堆顶，那么把堆顶弹出不要，当前的数字放入堆里面，如果大于等于，不管。
        for (int i=k; i<arr.length; i++){
            if (arr[i] > heapArr[0]){
                heapArr[0] = arr[i];
                heapify(heapArr, 0, heapSize);
            }
        }
        return heapArr[0];
    }

    /**
     * 将arr的第index位置的数保持在堆里面合适的位置
     * 一般发生在建成堆之后改变了index位置的值的时候
     * @param heapArr
     * @param index
     * @param heapSize 代表堆的大小
     */
    public static void heapify(int[] heapArr, int index, int heapSize){
        int left = 2 * index + 1;  //左孩子的下标
        while (left < heapSize){
            //判断哪个孩子更小。因为要维持小根堆，所以是让最小的到子树的根节点上面
            int least = left + 1 < heapSize && heapArr[left+1] < heapArr[left] ? left+1 : left;
            least = heapArr[least] < heapArr[index] ? least : index;
            if (least == index){
                break;
            }
            swap(heapArr, index, least);
            index = least;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
