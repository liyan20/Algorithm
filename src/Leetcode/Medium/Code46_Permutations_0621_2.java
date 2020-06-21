package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/21 12:21
 * @Title&Description: 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @Analysis:
 * 左神讲的这道题，暴力递归算法
 * 看要求是把单个的排列放入list里面去
 * @Summary:
 * @TimeConsuming:
 */
public class Code46_Permutations_0621_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for (int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        if (nums == null){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1){
            return res;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            numsList.add(nums[i]);
        }
        List<Integer> path = new ArrayList<>();
        process(numsList, path, res);
        return res;
    }

    //递归函数
    //numsList代表输入的字符，path代表一路选择的结果，res代表最终输出的list
    public static void process(List<Integer> numsList, List<Integer> path, List<List<Integer>> res){
        if (numsList.isEmpty()){
            //这边具体为啥还要思考一下
            res.add(path);
            return;
        }
        for (int i=0; i<numsList.size(); i++){
            //这里面的path要注意，如果是直接传入path的话，因为是引用传递，所以会直接改变path的值，
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(numsList.get(i));
            List<Integer> next = new ArrayList<>(numsList);
            next.remove(i);
            process(next, newPath, res);
            //回溯到这边，说明上一个process搞完了，回到这个位置了，说明下面的搜索结束了，那么就要把状态恢复到刚到这个地方的时候
            //对应的就是循环里面path.add的逆过程，撤销
//            path.remove(path.size() - 1);
        }
    }
}
