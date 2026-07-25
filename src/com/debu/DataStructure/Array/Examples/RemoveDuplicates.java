package com.debu.DataStructure.Array.Examples;

import java.util.HashSet;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums)
    {
        int k = 1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != nums[k-1])
            {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public int[] removeDuplicates2(int[] nums)
    {
        HashSet<Integer> elementSet = new HashSet<Integer>();
        int[] arr = new int[elementSet.size()];
        int i = 0;
        for(int num:nums)
        {
            elementSet.add(num);
        }
        for(Integer num:elementSet)
        {
            arr[i++] = num;
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,4,6,6,8,8};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int k = removeDuplicates.removeDuplicates(nums);
        System.out.println(k);
    }
}
