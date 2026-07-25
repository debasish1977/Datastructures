package com.debu.DataStructure.latestArray.Examples;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> elementSet = new HashSet<Integer>();
        for(int num:nums)
        {
            if(!elementSet.add(num))
            {
                return true;
            }
        }
        return false;
    }

    //O(nlogn) -- time complexity
    //O(1) --> Space complexity
    public boolean containsDuplicate2(int[] nums)
    {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1])
            {
                return true;
            }
        }
        return false;
    }
}
