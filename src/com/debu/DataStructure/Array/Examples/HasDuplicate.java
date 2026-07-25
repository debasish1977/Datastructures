package com.debu.DataStructure.Array.Examples;

import java.util.HashSet;

public class HasDuplicate {
//    public boolean hasDuplicate(int[] nums) {
//        int k = 1;
//        if(nums.length == 0)
//            return false;
//
//        for(int i=1;i<nums.length;i++)
//        {
//            if(nums[i] == nums[k-1])
//            {
//
//                return true;
//            }
//            k++;
//        }
//        return false;
//    }
//    public static void main(String[] args)
//    {
//        int[] nums = {1,2,3,3};
//        HasDuplicate hasDuplicate = new HasDuplicate();
//        boolean output = hasDuplicate.hasDuplicate(nums);
//        System.out.println(output);
//    }
    public boolean hasDuplicate(int[] nums)
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
}
