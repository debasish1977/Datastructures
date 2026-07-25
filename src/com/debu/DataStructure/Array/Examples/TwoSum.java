package com.debu.DataStructure.Array.Examples;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */

//Time Complexity:  O(n)
//Space Complexity:  O(n)

public class TwoSum {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> elementsMap = new HashMap<Integer,Integer>();
        int[] output = new int[2];
        int remainder = 0;
        for(int i=0;i<nums.length;i++)
        {
            remainder = target - nums[i];
            if(elementsMap.containsKey(remainder))
            {
                output[0] = i;
                output[1] = elementsMap.get(remainder);
            }
            else
            {
                elementsMap.put(nums[i],i);
            }
        }
        return output;
    }



}
