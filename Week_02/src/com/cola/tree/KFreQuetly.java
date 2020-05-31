package com.cola.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFreQuetly {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        //获取词频率
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        //加入堆进行频率大小过滤
        for (int it : hashMap.keySet()) {
            pQueue.add(it);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        //返回结果
        int[] result = new int[k];
        int i = 0;
        while (!pQueue.isEmpty()) {
            result[i] = pQueue.poll();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(input, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
