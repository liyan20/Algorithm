package NowcoderAlgorithm_Part1_1.class02;

/**
 * @Author: xianz
 * @Date: 2020/5/28 22:01
 * @Title&Description: 归并排序
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,5,586,345,36,75};
        mergeSort(arr, 0, arr.length-1);
        for(int temp : arr){
            System.out.println(temp);
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(arr==null){
            return;
        }
        if(l == r){
            return;
        }
        //这里面右移的代码要加上括号
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r){
        //这里最后要把temp给传到原数组里面，避免每次递归都新建并且保存一个
        //左数组是left-mid，右数组是mid+1--right
        int[] temp = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        //原来的数组还是一个整体，只不过人为给分开了
        while (p1<=mid && p2<=r){
            temp[i++] = arr[p1]<=arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= r){
            temp[i++] = arr[p2++];
        }
        //这个地方要注意，arr是从L开始加的
        for(int j=0;j<temp.length;j++){
            arr[l+j] = temp[j];
        }
    }
}
