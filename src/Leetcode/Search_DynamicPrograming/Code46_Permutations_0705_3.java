package Leetcode.Search_DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/7/5 10:33
 * @Title&Description: 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Analysis:
 * 回溯算法，再练习一下
 * 回溯就是一个劲往下找，找到不行了，返回上一级，再换个方向找。
 * 其中是不允许重复的，所以要维护一个数组或者set保证走过的不会再走。
 * 同时，返回上一级的时候，要把上次找的经过的地方给去掉，表面上次的地方在这次是可以走的
 * 这个和DFS有点不一样，DFS是要走完所有的点，里面没有撤销上次的路径的操作，回溯一般是有path这个东西的
 * 路径上每个点的变化都是不同的path
 *
 * 注意：每次递归的path都要是新的，即为不可变变量最好，每次都要新建一个path
 * 每次新建path或者是用String不可变类自动新建，这样最后保存path的时候，不会因为下面改变了path而改变
 * 或者是每次保存的时候都new一个新的保存，见下面两种方法
 * @Summary:
 * @TimeConsuming:
 */
public class Code46_Permutations_0705_3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return res;
        }
        int[] isVisited = new int[nums.length];
        process(res, nums, isVisited, new ArrayList<>());
        return res;
    }

    //回溯函数。其实也是递归的一种啦
    //递归参数：1.判断是否走过的数组；2.当前已经走过的路径
    public static void process(List<List<Integer>> res, int[] nums, int[] isVisited, List<Integer> path){
        //base case。当path里面的数值和nums一样，说明选择了所有的数的时候i，放入res的list，返回
        if (path.size() == nums.length){
            res.add(path);
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (isVisited[i] == 0){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                isVisited[i] = 1;
                process(res, nums, isVisited, newPath);
                //到了这一步，说明选择的第i个数字的操作结束了，开始选择第i+1个数字了，当然要把上面的对第i个数字的
                //访问数组为1的情况返回0;
                //即每次回溯撤销是在递归函数的下面，撤销的内容是递归函数上面改变了递归参数的逆过程
                //这里面的上面的传入递归函数的path是新的，所以不需要管他
                isVisited[i] = 0;
            }
        }
    }

    public static void process2(List<List<Integer>> res, int[] nums, int[] isVisited, List<Integer> path){
        //base case。当path里面的数值和nums一样，说明选择了所有的数的时候i，放入res的list，返回
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (isVisited[i] == 0){
                path.add(nums[i]);
                isVisited[i] = 1;
                process2(res, nums, isVisited, path);
                //到了这一步，说明选择的第i个数字的操作结束了，开始选择第i+1个数字了，当然要把上面的对第i个数字的
                //访问数组为1的情况返回0;
                //即每次回溯撤销是在递归函数的下面，撤销的内容是递归函数上面改变了递归参数的逆过程
                //刚刚的过程是path这个参数直接修改了，所以下面要给改回去
                isVisited[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
}
