package Leetcode_EasyAlgorithm.Array;

/**
 * @Author: xianz
 * @Date: 2020/5/9 14:06
 * @Title: 两个数组的交集 II
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @Analysis: 1.最简单的想法，放入两个hashmap里面,然后比较相同的和个数
 * 2.把nums1放入ArrayList，对比num2，如果有的话，就记录，然后把list1里面的这个给删掉
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Question06_0509_4 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,8,4};
        int[] out = intersect3(nums1, nums2);
        for (int i=0;i<out.length;i++){
            System.out.print(out[i]);
        }
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            int temp = nums1[i];
            if(!map1.containsKey(temp)){
                map1.put(temp,1);
            }else{
                map1.put(temp,map1.get(temp)+1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            int temp = nums2[i];
            if(!map2.containsKey(temp)){
                map2.put(temp,1);
            }else{
                map2.put(temp,map2.get(temp)+1);
            }
        }
        Set<Integer> set = map1.keySet();
        List<Integer> list = new ArrayList<>();
        for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
            int temp = iter.next();
            if(map2.containsKey(temp)){
                for(int i=0;i<Math.min(map1.get(temp),map2.get(temp));i++){
                    list.add(temp);
                }
            }
        }
        int[] list2 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            list2[i] = list.get(i);
        }
        return list2;
    }

    public static int[] intersect2(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int temp:nums2){
            if(list.contains(temp)){
                list2.add(temp);
                list.remove(Integer.valueOf(temp));
            }
        }
        int[] out = new int[list2.size()];
        for(int i=0;i<list2.size();i++){
            out[i] = list2.get(i);
        }
        return out;
    }
    public static int[] intersect3(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i=0,j=0; i<nums1.length && j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums2[j]<nums1[i]){
                j++;
            }else if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] out = new int[list.size()];
        for(int i=0;i<list.size();i++){
            out[i] = list.get(i);
        }
        return out;
    }
}
