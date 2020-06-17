package NowcoderAlgorithm_Part1_1.class02;

/**
 * @Author: xianz
 * @Date: 2020/5/30 09:04
 * @Title&Description: 堆排序
 * @Analysis: 堆在物理上实现是一个数组，实际情况是一个完全二叉树，就是每层按照从左到右的顺序的
 * 对于每一个位置i，其左孩子是2i+1，右孩子是2i+2，父节点是(i-1)/2。
 * 1.有效size：指的是数组里面构成完全二叉树的节点数量。在有效size里面的才是堆，之外的不算在堆里面
 * 2.大根堆：在完全二叉树中，每一个子树的最大值都是子树的头结点。将一个数插入大根堆：可以用每一个节点i，和其父节点比较，如果大于
 * 父节点，就交换，就可以了。保证子树的根节点是子树最大的就行。
 * 3.heapInsert操作：给一个结点插入大根堆，可以用每一个节点i，和其父节点比较，如果大于父节点，就交换。直到不大于父节点
 * 或者当前位置已经到了整个树的根的位置了，停止。每次这样操作保证插入之后还是大根堆
 * 4.取出最大值：因为是大根堆，当前大根堆的最大值就是数组的第一个元素
 * 5.heapify操作：将数组第一个元素和堆的最后一个交换，同时有效size-1，这样就可以把最大值放到数组最后了。
 * 这时候堆的根节点是之前堆的最后一个元素，这时候可能就不是大根堆了，就需要进行操作，叫做heapify。
 * heapify是指的，对于结点i，比较当前节点与左右孩子的大小，如果小于其中一个孩子，就交换，接着比较下面的。
 * 直到不小于两个孩子或者不存在孩子时，结束，
 * @ThinkingSteps: 堆排序的顺序：
 * 1.针对每一个数，进行heapInsert的操作，使其变成大根堆。
 * 2.之后将堆的根节点与堆最后一个结点交换，有效size-1，进行heapify操作
 * 3.继续2，直到有效size为0
 * @TimeConsuming:
 */
public class Code03_HeapSort {
    public static void main(String[] args) {
        int[] arr = {6,1,5,7,5,586,345,36,75};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //把数组一个个数变成大根堆
        for(int i=0;i<arr.length;i++){
            heapInsert(arr, i);
        }

        //或者用这个方法，如果直接给的是一整个数组，就可以直接从堆的底层开始，一个个进行heapify，就可以得到大根堆
        //时间复杂度是O（n）
//        for(int i=arr.length-1; i>=0; i--){
//            heapify(arr, i, arr.length);
//        }

        //heapSize是数组长度
        int heapSize = arr.length;
        //交换之后，heapSize-1
        swap(arr, 0, --heapSize);
        while (heapSize>0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //将heapInsert定义为将第i个结点插入堆中成为大根堆
    //与父节点比较，大的话就交换
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr, index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //将第i的位置的结点调整位置，使其保持大根堆
    //与左右孩子结点比较，小于的话就交换
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            //largest是两个孩子的最大值的下标
            int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;
            largest = largest > index ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (arr[i] != arr[j]){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
