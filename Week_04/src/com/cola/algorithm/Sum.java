package com.cola.algorithm;

import java.util.*;

public class Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 10, 0};
        twoSum(nums,9);
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("三数之和" + threeSum2(nums,0));
    }
    //使用hash表进行优化。leetcode上有讨论说不一定是优化，个人想法是优化
    public static List<List<Integer>> twoSum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int com = target -nums[i];
            if(container.containsKey(com)){
                System.out.println(container.get(com) + ","+ i );
                return result;
            }
            container.put(nums[i],i);
        }
        return result;
    }
    //这种解法时间复杂度为O(N^3),超过了leetCode的时间复杂度限制
    public static List<List<Integer>> threeSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int a = 0; a < nums.length - 2; a++){ //选取第一个元素，边界值为倒数第三个元素
            if( a> 0 &&nums[a] == nums[a-1]) continue;

            for(int b = a + 1;b < nums.length - 1;b++){ //选取第二个元素，
                if(b>a+1 && nums[b] == nums[b-1]) continue;
                for (int c = b +1; c < nums.length ; c++) {
                    if( c > b+1 && nums[c] == nums[c-1]) continue;
                    if(nums[a] + nums[b] + nums[c] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        result.add(list);
                    }
                }

            }
        }
        return result;
    }

    //因为递增的规律选择了双指针的方式，优化代码。
    public static List<List<Integer>> threeSum2(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int a = 0; a < nums.length ; a++){ //选取第一个元素，边界值为倒数第三个元素
            if( a> 0 &&nums[a] == nums[a-1]) continue;
            int midTarget = target -nums[a];
            int c = nums.length - 1;
            for(int b = a + 1;b < nums.length ;b++){ //选取第二个元素，
                if(b>a+1 && nums[b] == nums[b-1]) continue;
                while(b < c && nums[b] + nums[c] > midTarget ){
                    c--;
                }
                if(c == b){
                    break;
                }
                if( nums[b] + nums[c] == midTarget){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    //官方题解
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
