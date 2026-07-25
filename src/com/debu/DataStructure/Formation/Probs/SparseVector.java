package com.debu.DataStructure.Formation.Probs;

import java.util.HashMap;

public class SparseVector {
    HashMap<Integer,Integer> map;
    int length;
    SparseVector(int[] nums) {
        map = new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++)
        {
            map.put(i,nums[i]);
        }
        length = nums.length;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for(int key:this.map.keySet())
        {
            if(vec.map.containsKey(key))
            {
                result += this.map.get(key) * vec.map.get(key);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,0,0,2,3};
        int[] nums1 = {0,3,0,4,0};
        SparseVector v1 = new SparseVector(nums);
        SparseVector v2 = new SparseVector(nums);
        System.out.println(v1.dotProduct(v2));

    }
}
