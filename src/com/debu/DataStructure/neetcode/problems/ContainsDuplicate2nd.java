package com.debu.DataStructure.neetcode.problems;

import java.util.Arrays;

//Time complexity: O(nlogn) -- due to sorting
//Space complexity: O(1)

public class ContainsDuplicate2nd {
    public boolean containsDuplicate(int[] nums)
    {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                return true;
            }
        }
        return false;
    }
}
