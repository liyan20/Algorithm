package Leetcode.Coding;

import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/7/27 11:08
 * @Title&Description: 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @Analysis:
 * 遇到题目先看看是怎么弄得。如果自己想应该是怎么想。
 * 这题的思路是首先把二维数组按照里面的数组的第一位排序。
 * 设置一个list保存最终的结果，之后先把第一个数组放进去，然后看下面的数组，
 * 如果数组的起点大于list里面的数组的终点，说明肯定不会重合，就把这个数组放入list；
 * 如果数组的起点小于等于list里面的数组的终点，那就判断一下两个数组谁的终点大，把list里面的数组更新终点。
 * 除了第一个数组之外，每一次遍历的二维数组，其要考虑的数组都是list里面的最后一个即最新的一个，这个要注意。
 * @Summary:
 * @TimeConsuming:
 */
public class Code56_MergeIntervals_0727_2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++){
            //第一个的时候，直接放进去
            if (i == 0){
                list.add(intervals[0]);
            }else {
                //每一次遍历的二维数组，其要考虑的数组都是list里面的最后一个，即最新的一个
                int[] curRes = list.get(list.size()-1);
                //如果数组的起点大于list里面的数组的终点，说明肯定不会重合，就把这个数组放入list；
                if (intervals[i][0] > curRes[1]){
                    list.add(intervals[i]);
                }else {
                    //如果数组的起点小于等于list里面的数组的终点，
                    // 那就判断一下两个数组谁的终点大，把list里面的数组更新终点
                    curRes[1] = Math.max(curRes[1], intervals[i][1]);  //因为数组也是对象，直接更新就行了
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
