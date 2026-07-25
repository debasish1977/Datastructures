package com.debu.DataStructure.Company.Examples;
//Intuit Question
//arr = [1,2,3,4,5]
//req = [2,5]

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CircularArray {
    public static int minLength(int[] arr, int[] req) {
        int n = arr.length;
        Set<Integer> reqSet = new HashSet<>();
        for (int r : req) reqSet.add(r);

        Map<Integer, Integer> countMap = new HashMap<>();
        int required = reqSet.size();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;

        int[] arr2 = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) arr2[i] = arr[i % n];

        int left = 0;
        for (int right = 0; right < 2 * n; right++) {
            int val = arr2[right];
            if (reqSet.contains(val)) {
                countMap.put(val, countMap.getOrDefault(val, 0) + 1);
                if (countMap.get(val) == 1) {
                    formed++;
                }
            }

            // shrink while valid
            while (formed == required && left <= right) {
                if (right - left + 1 <= n) {
                    minLen = Math.min(minLen, right - left + 1);
                }
                int lval = arr2[left];
                if (reqSet.contains(lval)) {
                    countMap.put(lval, countMap.get(lval) - 1);
                    if (countMap.get(lval) == 0) {
                        formed--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] req = {2, 5};
        System.out.println(minLength(arr, req)); // Output: 3
    }


}
