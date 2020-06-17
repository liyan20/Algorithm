package NowcoderAlgorithm_Part1_1.class02;

/**
 * @Author: xianz
 * @Date: 2020/6/4 08:58
 * @Title&Description: 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 * 接口说明
 * 原型：
 * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
 * 输入参数：
 * Integer[] pIntegerArray：整型数组
 * int  iSortFlag：排序标识：0表示按升序，1表示按降序
 * 输出参数：
 * 无
 * 返回值：
 * void
 * 输入描述:
 * 1、输入需要输入的整型数个数
 * 输出描述:
 * 输出排好序的数字
 * 示例1
 * 输入
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出
 * 1 2 3 4 9 25 55 64
 * @Analysis: 对数组进行排序，那就正好练习一下快速排序3.0吧
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Test01_0604_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            Integer[] pIntegerArray = new Integer[num];
            for (int i=0; i<num; i++){
                pIntegerArray[i] = sc.nextInt();
            }
            int iSortFlag = sc.nextInt();
            sortIntegerArray(pIntegerArray, iSortFlag);
            for (int i=0; i<pIntegerArray.length; i++){
                System.out.print(pIntegerArray[i]);
                if (i != pIntegerArray.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag){
        if (pIntegerArray == null || pIntegerArray.length < 2){
            return;
        }
        quickSort(pIntegerArray, 0, pIntegerArray.length-1);
        if (iSortFlag == 1){
            for (int i=0; i<pIntegerArray.length/2; i++){
                Integer temp = pIntegerArray[i];
                pIntegerArray[i] = pIntegerArray[pIntegerArray.length-1-i];
                pIntegerArray[pIntegerArray.length-1-i] = temp;
            }
        }
    }

    public static void quickSort(Integer[] arr, int L, int R){
        if (L >= R){
            return;
        }
        swap(arr, L+(int)(Math.random()*(R-L+1)), R);
        int[] p = partition(arr, L, R);
        quickSort(arr, L, p[0]-1);
        quickSort(arr, p[1]+1, R);
    }

    //快速排序partition过程，小于p的放在左边，等于p的放在中间，大于p的放在右边，返回等于p的范围
    //要进行交换
    public static int[] partition(Integer[] arr, int L, int R){
        //在[L..R-1]范围上进行partition过程，这里面已经确定p的类型是int，就不需要对Integer拆箱了
        int p = arr[R];
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more){
            if (arr[index] < p){
                swap(arr, index++, ++less);
            }
            else if(arr[index] > p){
                swap(arr, index, --more);
            }else{
                index++;
            }
        }
        swap(arr, more++, R);
        return new int[] {less+1, more-1};
    }

    //这个是Integer数组，没法用与运算了
    public static void swap(Integer[] arr, int i, int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
