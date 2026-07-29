package com.debu.DataStructure.Hashing;
//Clarifying questions
//Input array contains both +ve & -ve integers?
//Input array can be empty?

//Approach
//Approach 1: Nested Loops -- O(N2), O(1)
//Approach 2: Sort first -- O(NlogN)
//Approach 3: Using HashSet

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0)return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
