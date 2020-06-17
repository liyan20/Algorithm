package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/10 17:20
 * @Title: 移动零
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @Analysis: 1.这题第一想法就是类似与冒泡排序那种，把0给移到最右边。好像不行啊这个。行的，没问题
 * 2.如果直接交换的话，后面如果有0，就会把这个0给交换，这个0就会跑到前面去，就会被忽略掉
 * 3.设定条件，不是j和j+1交换，而是找到第一个不是0的j+1
 * 法2：看的题解，两个index，所有不是0的给放到前面，在最后补0就行了
 * @ThinkingSteps:
 * @TimeConsuming:
 */
public class Question09_0510_3 {
    public static void main(String[] args) {
        int[] nums = {3,5,6,1,8,7,0};
        moveZeroes1(nums);
        for(int num:nums){
            System.out.print(num+",");
        }
    }
    public static void moveZeroes1(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }
        if(j<nums.length){
            for(int i=j;i<nums.length;i++){
                nums[i] = 0;
            }
        }
    }
    public static void moveZeroes2(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0){
                for(int j=i;j<nums.length-1;j++){
                    int tempIndex = j+1;
                    while(nums[tempIndex]==0 && tempIndex<nums.length-1){
                        tempIndex++;
                    }
                    int temp =nums[tempIndex];
                    nums[tempIndex] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
