package Hashing;

//Clarifying questions
//Contains both +ve & -ve integers?
//Input array can be empty?

//Approach
//I will solve this using HashSet
//First I will iterate throguh the array and if any of those elements exist in the HashSet
//If any of the element exists in the HashSet then it will return true else will return false

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length==0)return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
