package SortAlgorithm;

/**
 * @Author: xianz
 * @Date: 2020/8/14 10:18
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

/**
 * 小根堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        sort(arr);
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        //这个heapify的方法必须是从堆的结束位置开始建立的
        int heapSize = arr.length;
        for (int i=arr.length-1; i>=0; i--){
            heapify(arr, i, heapSize);
        }
        //小根堆的第一个数是最小的，将其与heapsize的最后一位交换，heapSize-1是指的最后一位不在堆里面了
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            //之后是继续，交换之后heapifu一下，将交换过来的那个放到应该的位置上面，然后接着交换第一位的数。
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
        //这边是因为写的是小根堆，其实是逆序的
        for (int i=0; i<arr.length/2; i++){
            swap(arr, i, arr.length-1-i);
        }
    }

    /**
     * heapInsert和heapify建立堆的方法选一个就行。
     * @param arr
     */
    public static void heapGenerator1(int[] arr){
        for (int i=0; i<arr.length; i++){
            heapInsert(arr, i);
        }
    }
    public static void heapGenerator2(int[] arr){
        int heapSize = arr.length;
        for (int i=arr.length-1; i>=0; i--){
            heapify(arr, i, heapSize);
        }
    }


    /**
     * 将第index位置的数插入堆。这个并不是必须的，只发生在需要一个一个插入的时候
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index){
        while (arr[index] < arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 将arr的第index位置的数保持在堆里面合适的位置
     * 一般发生在建成堆之后改变了index位置的值的时候
     * @param arr
     * @param index
     * @param heapSize 代表堆的大小
     */
    public static void heapify(int[] arr, int index, int heapSize){
        int left = 2 * index + 1;  //左孩子的下标
        while (left < heapSize){
            //判断哪个孩子更小。因为要维持小根堆，所以是让最小的到子树的根节点上面
            int least = left + 1 < heapSize && arr[left+1] < arr[left] ? left+1 : left;
            least = arr[least] < arr[index] ? least : index;
            if (least == index){
                break;
            }
            swap(arr, index, least);
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
