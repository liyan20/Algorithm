package Collections;

/**
 * @Author: xianz
 * @Date: 2020/9/16 19:26
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class gerg {
    public static void main(String[] args) {
        int[] arr1 = {23,40};
        int[] arr2 = {1,3};
        int[] arr = operate(arr1, arr2);
        System.out.println();
    }

    public static int[] operate (int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int index = 0;
        for(int i=0; i<arr1.length; i++){
            arr[index++] = arr1[i];
        }
        for(int i=0; i<arr2.length; i++){
            arr[index++] = arr2[i];
        }
        int[] res = new int[arr.length-1];
        index = 0;
        for(int i=0; i<arr.length; i++){
            if(i != arr.length-2){
                res[index++] = arr[i];
            }
        }
        return res;
    }
}
