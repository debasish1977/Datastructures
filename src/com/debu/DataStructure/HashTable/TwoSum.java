package com.debu.DataStructure.HashTable;

import java.util.HashMap;

public class TwoSum {
    public int[] returnSum(int[] nums,int target)
    {
        int[] output = new int[2];
        int remainder = 0;
        HashMap<Integer,Integer> elementsMap = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
        {
            remainder = target - nums[i];
            if(elementsMap.containsKey(remainder))
            {
                output[0] = i;
                output[1] = elementsMap.get(remainder);
            }
            else {
                elementsMap.put(nums[i],i);
            }
        }
        return output;
    }
}
