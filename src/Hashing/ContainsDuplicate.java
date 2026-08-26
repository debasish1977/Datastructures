package Hashing;

//Clarifying questions
//if the input array can contain both +ve & -ve integers?
//If the input array can be empty?
//Are there any constraints on the size of the array or range of the integers?

//Approach
//I'll scan the array once while maintaining a HashSet containing every value I've seen so far. For each number, if it's already in the set, //we've found a duplicate and can immediately return true. Otherwise, I add it to the set. If we finish the scan, all elements were unique.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length < 2) return false;
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }
}
