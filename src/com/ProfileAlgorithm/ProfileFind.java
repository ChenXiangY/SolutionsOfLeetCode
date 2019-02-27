package com.ProfileAlgorithm;

/**
 * 自己学习算法的查找的类
 *
 * @author Chen Xiangyu
 * @version 1.0
 * @classname ProfileFind
 * @date 2019/2/9
 */
public class ProfileFind {


    /*
    迭代的方法实现二分查找.
     * @author Chen Xiangyu
     * @date  2019/2/9 10:43
     * @param nums 查找的目标数组
     * @param a 要查找的值
     * @return int
     */
    public int rank(int[] nums, int a) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > a) {
                hi = mid - 1;
            } else if (nums[mid] < a) {
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return lo;
    }
}
