package com.debu.DataStructure.Array.Examples;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 */

//Time Complexity:  O(n)
//Space Complexity:  O(1)

public class RemoveElementWorking {
    public int removeElements(int[] nums, int val)
    {
        int k = 0;
        for(int i= 0;i<nums.length;i++)
        {
            if(nums[i] == val)
            {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
