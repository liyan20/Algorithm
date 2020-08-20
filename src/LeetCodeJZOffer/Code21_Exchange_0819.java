package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/19 15:28
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code21_Exchange_0819 {
    /**
     * 使用快速排序的aprtition过程。设置两个指针，一个是index，一个是more
     * 每次判断当前的数，如果是偶数，那么和--more的交换并且index不动，然后接着判断交换过来的那个，
     * 如果是奇数，直接index++
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length < 1){
            return nums;
        }
        int index = 0;
        int more = nums.length;
        while(index < more){
            if(nums[index] % 2 == 0){
                swap(nums, index, --more);
            }else{
                index++;
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int i, int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
