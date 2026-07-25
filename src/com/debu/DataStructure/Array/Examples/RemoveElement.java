package com.debu.DataStructure.Array.Examples;

import java.util.ArrayList;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> elements = new ArrayList<>();
        int k =0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==val)
            {
                continue;
            }
            elements.add(nums[i]);
        }
        // Convert to Integer[]
        k = elements.size();
        return k;
    }

    public static void main(String[] args)
    {
        int[] nums = {3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        int k = removeElement.removeElement(nums,3);
        System.out.println(k);
    }
}


/*
ArrayList<Integer> elements = new ArrayList<>();
        int k =0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==val)
            {
                continue;
            }
            elements.add(nums[i]);
        }
        // Convert to Integer[]
        k = elements.size();
        return k;
 */
