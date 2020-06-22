package Leetcode.Easy;

/**
 * @Author: xianz
 * @Date: 2020/6/22 11:47
 * @Title&Description: 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 示例:
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * @Analysis:
 * 直接搜索不行。会超时
 * 换用二分查找
 * @Summary:
 * @TimeConsuming:
 */
public class Code278_FirstBadVersion_0622_2 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

    public static boolean isBadVersion(int version){
        if (version <= 3){
            return false;
        }else {
            return true;
        }
    }

    public static int firstBadVersion(int n) {
        return process(1, n);
    }

    public static int process(int L, int R){
        if (L == R){
            return L;
        }
        int mid = L + ((R - L) >> 1);
        if (isBadVersion(mid)){
            return process(L, mid);
        }else {
            return process(mid + 1, R);
        }
    }
}
