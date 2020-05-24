package com.cola.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = new Solution().twoSum(nums, 9);
        for (int value : result) {
            System.out.println("result" + value);
        }
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {

                for (int j = i + 1; j < nums.length; j++) {
                    if (target - nums[i] - nums[j] == 0) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
            return result;
        }
    }

}
