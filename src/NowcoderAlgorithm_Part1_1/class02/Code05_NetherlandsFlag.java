package NowcoderAlgorithm_Part1_1.class02;

/**
 * @Author: xianz
 * @Date: 2020/5/30 16:09
 * @Title&Description: 荷兰国旗问题
 * 分三块，在arr[L...R]范围上，小于p的放左边，等于p的放中间，大于p的放右边
 * @Analysis: 如果是小于p，就和小于区边界右边的元素交换，小于区边界+1，i+1。
 * 如果是等于p，i+1，其他的不动
 * 如果是大于p，就和大于区边界的左边的元素交换，大于区边界-1，i不动，因为要判断换过来的数是什么情况
 * 当前的i的位置，保证从一开始到小于区边界都是小于的，从小于区边界+1到i的地方都是等于的，在大于区边界到最后都是大于的
 * 而从i到大于区边界是还没有判断的。
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Code05_NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = {6,1,5,7,4,5,586,345,1,2,4,36,754,4,3,3};
        partition2(arr, 0, arr.length-1, 4);
        System.out.println();
        for (int temp : arr){
            System.out.println(temp);
        }

    }

    //返回是一个长度为2的数组，里面包含了等于区域的左边界和右边界
    //其实返回的是小于区域的右边和大于区域的左边，如果返回的等于区域的左边界大于右边界，那么说明没有等于区域
    public static int[] partition(int[] arr, int L, int R, int p){
        //L和R是代表在从数组L到R上来处理
        int less = L-1;
        int more = R+1;
        //这里面不能用i<=R作为判断，因为如果是大于p，我们的i是不动的，因为要判断换过来的那个是什么情况，
        // 所以如果是判断所有的数的话，有可能是已经判断过了还要接着判断，就会溢出，因为不是所有情况都是i++的
        //所以我们遍历结束的标志是i和右边界相遇。为什么不考虑左边界呢，因为左边界和i是同步+1的。
        //右边界包括边界往右都是判断过的，而左边界和i是同步的，左边界不可能比i走的还快
        int i = L;
        while (i < more) {
            if(arr[i] < p){
                swap(arr, i++, ++less);
                //至于这边为什么i可以++而下面的不行，是因为在i左边的都是已经判断过的
                //都是小于等于p的，已经判断过了，所以不需要判断。下面的是和i右边的交换，
                // 是多大的数都有可能，所以i不能直接++
            }else if(arr[i] > p){
                swap(arr, i, --more);
            }else if(arr[i] == p){
                i++;
            }
        }
        return new int[] {less+1, more-1};
    }

    //这个是划分两块，小于等于的在左边，大于的在右边，这样只需要维护一个less就行了
    //小于等于的是在左边，与小于区域下一个交换，如果是大于就直接i++
    public static void partition2(int[] arr, int L, int R, int p){
        int less = L-1;
        int index = L;
        while (index <= R){
            if(arr[index] <= p){
                swap(arr, index++, ++less);
            }else {
                index++;
            }
        }
    }


    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
