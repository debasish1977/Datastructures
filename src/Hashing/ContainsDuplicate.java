package Hashing;

//Clarifying questions
//The input array contains both +ve & -ve integers?
//The input array can be empty?

//Approach
//I will solve this using HashSet
//I will iterate through the input array and then first check if the element exists in the input array
//If exists, then return true, else return false

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
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
