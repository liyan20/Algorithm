package LeetCodeJZOffer;

/**
 * @Author: xianz
 * @Date: 2020/8/24 12:37
 * @Title&Description: 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code51_ReversePairs_0824 {

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        return process(nums, 0, nums.length-1);
    }

    /**
     * 主方法。利用归并排序的过程来处理
     * @param nums
     * @param left
     * @param right
     * @return 返回这个范围的数组的逆序对的数量
     */
    public static int process(int[] nums, int left, int right){
        //只有一个数的情况，直接返回0，因为一个数不存在逆序对
        if(left == right){
            return 0;
        }
        int[] temp = new int[right - left + 1];
        int mid = left + ((right - left) >> 1);

        //递归得到左右数组的逆序对数，下面是要求分别在两个数组内的逆序对数
        int leftNum = process(nums, left, mid);
        int rightNum = process(nums, mid+1, right);

        int p1 = mid;
        int p2 = right;
        int index = temp.length - 1;
        int res = 0;
        //按照归并排序的merge过程，只不过是从右往左从大到小的合并
        while(p1 >= left && p2 >= mid+1){
            //当左边数组的数大于右边的时候，加上逆序对数，数量是右边数组到其左边界mid+1的长度
            //具体来说只有两个数第一个大于第二个才叫逆序对，而这个左边数组大于右边的，
            //所以右边数组那个数的整个左边的都属于逆序对了。
            if(nums[p1] > nums[p2]){
                res += (p2-mid);
                temp[index] = nums[p1];
                index--;
                p1--;
            }else{  //要是左边比右边小，不管他
                temp[index] = nums[p2];
                index--;
                p2--;
            }
        }
        //保存还剩下的。因为只剩下一个数组了，所以也不存在逆序对了
        while(p1 >= left){
            temp[index] = nums[p1];
            p1--;
            index--;
        }
        while(p2 >= mid+1){
            temp[index] = nums[p2];
            p2--;
            index--;
        }
        //将辅助数组复制到原数组中去
        index = left;
        for(int i=0; i<temp.length; i++){
            nums[index] = temp[i];
            index++;
        }
        return leftNum + rightNum + res;  //返回的是左数组和右数组的逆序对数加上分别在左右的逆序对数。
    }

}
