package com.debu.DataStructure.HashTable;

import java.util.HashMap;

//Time Complexity : O(n)
//Space Complexity : O(n)

public class TwoSum_Latest {
    public int[] twoSum(int[] nums, int target) {
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

    public static void main(String[] args)
    {
        TwoSum_Latest twoSum = new TwoSum_Latest();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] output = twoSum.twoSum(nums,target);
        for(int i =0;i<output.length;i++)
        {
            System.out.println(output[i]);
        }
    }
}
