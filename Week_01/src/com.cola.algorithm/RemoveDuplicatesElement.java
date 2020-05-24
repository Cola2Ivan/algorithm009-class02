package com.cola.algorithm;

//删除数组中的重复元素
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesElement{

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int pos = new Solution().removeDuplicates(nums);
        for(int i = 0; i < pos;i ++){
            System.out.println(nums[i]);
        }

    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int j = 0;
            for (int i = 1; i < nums.length; i++ ) {
                if (nums[i] != nums[j]) {
                    nums[j + 1] = nums[i];
                    j = j + 1;
                }
            }
            return j +1;
        }
    }
}